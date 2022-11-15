package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO{

	private static MemberDAO instance = new MemberDAOImpl(); // 인스턴스로 안만들고 널인지 확인하고 만들수도 있음.
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// DB연결
	private Connection getConnection() throws Exception{
		Context initCtx=new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	// DB 닫기
	private void closeConnection(Connection con, PreparedStatement ps,
			Statement st, ResultSet rs) {
		try {
			if(con !=null) 			con.close();
			if(ps !=null) 			ps.close();
			if(st !=null) 			st.close();
			if(rs !=null) 			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override // 추가
	public void memberInsert(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into MEMBERDB values (?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getPwd());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setInt(6, member.getAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, ps, null); // con, ps, null, null 도 괜찮다.
		}
	}

	@Override // 전체보기
	public ArrayList<MemberDTO> memberList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		
		try {
			con=getConnection();
			String sql = "select * from MEMBERDB";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setName(rs.getString("name"));
				member.setUserid(rs.getString("userid"));
				member.setPwd(rs.getString("pwd"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAdmin(rs.getInt("admin"));
				arr.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override // 수정 (업데이트)
	public void memberUpdate(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "update MEMBERDB set name=?, pwd=?,"
							  + " email=?, phone=?, admin=?"
						   	  + "where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.setInt(5, member.getAdmin());
			ps.setString(6, member.getUserid());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, ps, null);
		}
	}

	@Override // 삭제
	public void memberDelete(String userid) {
		Connection con = null;
		Statement st = null;
		try {
			con=getConnection();
			String sql = "delete from MEMBERDB where userid='" + userid + "'";
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
	}

	@Override // 상세보기
	public MemberDTO findById(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO member = null;
		
		try {
			con=getConnection();
			String sql = "select * from MEMBERDB where userid='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				member=new MemberDTO();
				member.setName(rs.getString("name"));
				member.setUserid(rs.getString("userid"));
				member.setPwd(rs.getString("pwd"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return member;
	}

	@Override // 아이디 중복체크
	public String idCheck(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag = "yes"; // 사용가능 
		
		try {
			con=getConnection();
			String sql = "select * from MEMBERDB where userid ='" +userid+ "'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) { // sql문 결과가 있으면 아이디 사용할 수 없다.
				flag="no";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
		
		return flag;
	}

	@Override // 로그인 체크
	public int loginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int flag = -1; // 회원 아님(-1), 회원 성공(0), 비번 오류(2) > 경우의 수 3가지.
		
		try {
			con=getConnection();
			String sql = "select pwd, admin from MEMBERDB where userid='" +userid+ "'";
			// 일반회원과 관리자 구분위해 admin 도 들고온다.
			
			// System.out.println(sql); // 에러뜰땐 sql문 콘솔창에 찍어 확인해보기.
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { // 0 또는 2 : 회원이거나, 비번오류
				if(rs.getString("pwd").equals(pwd)) { // 회원 : 입력한 비번이 맞는지 검사.
					flag = rs.getInt("admin"); // admin 값 0, 1 을 flag 에게 준다.
				} else { // 회원이지만 비번오류
					flag = 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		
		return flag;
	}

	@Override // 회원 수
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			String sql = "select count(*) from MEMBERDB";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
		return count;
	}

}
