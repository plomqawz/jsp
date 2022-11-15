package com.jqueryAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JAddressDAOImpl implements JAddressDAO{
	
	private static JAddressDAO instance = new JAddressDAOImpl();
	public static JAddressDAO getInstance() {
		return instance;
	}
	
	// DB연결
	private Connection getConnection() throws Exception{
		Context initCtx=new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env"); //가상의 폴더에서 찾아옴.
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp"); // 임의 이름등록해서 찾음.
		//  inf에 context.xml 복붙.
		return ds.getConnection();
	}
	
	@Override // 추가
	public void insert(AddressVO avo) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "insert into ADDRESS values (address_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, avo.getName());
			ps.setString(2, avo.getZipcode());
			ps.setString(3, avo.getAddr());
			ps.setString(4, avo.getTel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps,null,null);
		} 
	}

	@Override // 전체보기
	public ArrayList<AddressVO> list(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddressVO> arr = new ArrayList<AddressVO>();
		
		try {
			con=getConnection();
			String sql="select * from address";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setNum(rs.getInt("num"));
				avo.setAddr(rs.getString("addr"));
				avo.setName(rs.getString("name"));
				avo.setTel(rs.getString("tel"));
				avo.setZipcode(rs.getString("zipcode"));
				arr.add(avo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override // 상세보기
	public AddressVO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		AddressVO avo = null; // if 문 안에서 선언하면 리턴때 avo를 못씀.(에러남)
	
		try {
			con=getConnection();
			String sql="select * from address where num="+num;
			st = con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				avo = new AddressVO(); // 안쓰면 안됨. 아직 안만들어졌고 선언만 했기 때문.
				avo.setAddr(rs.getString("addr"));
				avo.setName(rs.getString("name"));
				avo.setNum(rs.getInt("num"));
				avo.setTel(rs.getString("tel"));
				avo.setZipcode(rs.getString("zipcode"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return avo;
	}

	@Override // 개수
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			String sql= "select count(*) from address order by num desc";
			st=con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,null,st,rs);
		}
		
		return count;
	}
	
	@Override // 수정
	public void update(AddressVO avo) {
		Connection con = null;
		PreparedStatement ps=null;
		
		try {
			con=getConnection();
			String sql="update address set name=?, tel=?,"
					+ " zipcode=?, addr=?"
					+ "where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, avo.getName());
			ps.setString(2, avo.getTel());
			ps.setString(3, avo.getZipcode());
			ps.setString(4, avo.getAddr());
			ps.setInt(5, avo.getNum());
			ps.executeUpdate(); // excute, excutequery 가능, 반환형이 다름. (불리안과 인트)
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, ps, null);
		}
	} 
	
	@Override // 삭제
	public void delete(int num) {
		Connection con = null;
		Statement st=null;
		try {
			con=getConnection();
			String sql="delete from address where num="+num;
			st=con.createStatement();
			st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, null);
		}
	}
	
	@Override // 우편번호 검색
	public ArrayList<ZipCodeVO> getZipcode(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipCodeVO> zarr = new ArrayList<ZipCodeVO>();
		
		try {	
		con=getConnection();
		String sql = "select * from zipcode where dong like '%" + dong + "%'";
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
		
			ZipCodeVO z = new ZipCodeVO();
			z.setBunji(rs.getString("bunji"));
			z.setDong(rs.getString("dong"));
			z.setGugun(rs.getString("gugun"));
			z.setSeq(rs.getInt("seq"));
			z.setSido(rs.getString("sido"));
			z.setZipcode(rs.getString("zipcode"));
			zarr.add(z);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		closeConnection(con, null, st, rs);
	}
		return zarr;
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

		// 전체보기 (검색)
		@Override
		public ArrayList<AddressVO> searchList(String field, String word) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			ArrayList<AddressVO> arr = new ArrayList<AddressVO>();
			
			try {
				con=getConnection();
				String sql = "select * from address where " + field + " like '%" + word + "%'";
				st = con.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					AddressVO avo = new AddressVO();
					avo.setNum(rs.getInt("num"));
					avo.setAddr(rs.getString("addr"));
					avo.setName(rs.getString("name"));
					avo.setTel(rs.getString("tel"));
					avo.setZipcode(rs.getString("zipcode"));
					arr.add(avo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection(con, null, st, rs);
			}
			
			return arr;
		}

		// 개수 (검색)
		@Override
		public int getCount(String field, String word) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			int count = 0;
			
			try {
				con=getConnection();
				String sql = "select count(*) from address where " + field + " like '%" + word + "%'";
				System.out.println(sql);
				st = con.createStatement();
				rs = st.executeQuery(sql);
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection(con, null, st, rs);
			}
			return count;
		}
}
