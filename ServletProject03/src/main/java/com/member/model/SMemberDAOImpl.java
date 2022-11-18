package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SMemberDAOImpl implements SMemberDAO{

	private static SMemberDAO instance = new SMemberDAOImpl();
	public static SMemberDAO getInstance() {
		return instance;
	}
	
	// DB����
	private Connection getConnection() throws Exception{
		Context initCtx=new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env"); //������ �������� ã�ƿ�.
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp"); // ���� �̸�����ؼ� ã��.
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
	
	@Override // ��� �߰�
	public void memberJoin(SMemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps=con.prepareStatement("insert into memberdb values (?, ?, ?, ?, ?, ?)");
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
			closeConnection(con, ps, ps, null);
		}
	}

	@Override
	public ArrayList<SMemberDTO> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberDelete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(SMemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SMemberDTO findById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String memberIdCheck(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // �α���
	public SMemberDTO memberLoginCheck(String userid, String pwd) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		SMemberDTO member = new SMemberDTO();
		// ��ȸ�� : -1
		member.setAdmin(-1);
		// ȸ�� : �Ϲ�ȸ��(0), ������(1)
		// ȸ�������� �������(2)
		
		try {
			con=getConnection();
			String sql="select * from memberdb where userid='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if (rs.next()) { // id ���� (ȸ���� ����)
				if (rs.getString("pwd").equals(pwd)) { // ��� ����
					member.setAdmin(rs.getInt("admin"));
					member.setEmail(rs.getString("email"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setPwd(rs.getString("pwd"));
					member.setUserid(rs.getString("userid"));
				} else { // ��� Ʋ��
					member.setAdmin(2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, null, null);
		}
		return member;
	}

}
