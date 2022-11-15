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

	private static MemberDAO instance = new MemberDAOImpl(); // �ν��Ͻ��� �ȸ���� ������ Ȯ���ϰ� ������� ����.
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// DB����
	private Connection getConnection() throws Exception{
		Context initCtx=new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	// DB �ݱ�
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
	
	@Override // �߰�
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
			closeConnection(con, ps, ps, null); // con, ps, null, null �� ������.
		}
	}

	@Override // ��ü����
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

	@Override // ���� (������Ʈ)
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

	@Override // ����
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

	@Override // �󼼺���
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

	@Override // ���̵� �ߺ�üũ
	public String idCheck(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag = "yes"; // ��밡�� 
		
		try {
			con=getConnection();
			String sql = "select * from MEMBERDB where userid ='" +userid+ "'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) { // sql�� ����� ������ ���̵� ����� �� ����.
				flag="no";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
		
		return flag;
	}

	@Override // �α��� üũ
	public int loginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int flag = -1; // ȸ�� �ƴ�(-1), ȸ�� ����(0), ��� ����(2) > ����� �� 3����.
		
		try {
			con=getConnection();
			String sql = "select pwd, admin from MEMBERDB where userid='" +userid+ "'";
			// �Ϲ�ȸ���� ������ �������� admin �� ���´�.
			
			// System.out.println(sql); // �����㶩 sql�� �ܼ�â�� ��� Ȯ���غ���.
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { // 0 �Ǵ� 2 : ȸ���̰ų�, �������
				if(rs.getString("pwd").equals(pwd)) { // ȸ�� : �Է��� ����� �´��� �˻�.
					flag = rs.getInt("admin"); // admin �� 0, 1 �� flag ���� �ش�.
				} else { // ȸ�������� �������
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

	@Override // ȸ�� ��
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
