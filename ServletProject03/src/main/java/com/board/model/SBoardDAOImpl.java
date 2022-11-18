package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class SBoardDAOImpl implements SBoardDAO{
	private static SBoardDAO instance = new SBoardDAOImpl();
	public static SBoardDAO getInstance() {
		return instance;
	}

	@Override // 게시글 추가
	public void boardInsert(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DBConnection.getConnection();
			String sql = "insert into simpleboard values (simpleboard_seq.nextval, ?, ?, ?, 0, ?, sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1, board.getUserid());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, null, null);
		}
	}

	@Override
	public void boardUpdate(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override // 게시글 전체보기
	public ArrayList<BoardDTO> boardList() {
		Connection con=null;
		Statement st=null;
		ResultSet rs = null;
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		
		try {
			con=DBConnection.getConnection();
			String sql="select * from simpleboard";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setUserid(rs.getString("userid"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRegdate(rs.getString("regdate"));
				arr.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override
	public ArrayList<BoardDTO> boardList(int startRow, int endRow, String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardDelete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int boardCount(String field, String word) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override // 게시글 상세보기
	public BoardDTO findByNum(int num) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		BoardDTO board=null;
		
		try {
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from simpleboard where num="+num);
			if (rs.next()) {
				board = new BoardDTO();
				board.setContent(rs.getString("content"));
		    	board.setEmail(rs.getString("email"));
		    	board.setNum(rs.getInt("num"));
		    	board.setReadcount(rs.getInt("readcount"));
		    	board.setRegdate(rs.getString("regdate"));
		    	board.setSubject(rs.getString("subject"));
		    	board.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return board;
	}

	@Override // 댓글 추가
	public void commentInsert(CommentDTO comment) {
		Connection con=null;
		PreparedStatement ps = null;
		
		try {
			con=DBConnection.getConnection();
			String sql = "insert into comboard"
					+ " values (comboard_seq.nextval, ?, ?, sysdate, ?)";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, comment.getMsg());
			ps.setString(2, comment.getUserid());
			ps.setInt(3, comment.getBnum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, null, null);
		}
	}

	@Override // 댓글 전체보기
	public ArrayList<CommentDTO> findAllComment(int bnum) {
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		ArrayList<CommentDTO> carr = new ArrayList<CommentDTO>();
		
		try {
			con=DBConnection.getConnection();
			st = con.createStatement();
			String sql = "select * from comboard where bnum=" +bnum+ " order by cnum desc";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setBnum(rs.getInt("bnum"));
				comment.setCnum(rs.getInt("cnum"));
				comment.setMsg(rs.getString("msg"));
				comment.setRegdate(rs.getString("regdate"));
				comment.setUserid(rs.getString("userid"));
				carr.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return carr;
	}

	@Override // 댓글 개수
	public int commentCount(int bnum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=DBConnection.getConnection();
			String sql = "select count(*) from comboard where bnum=" +bnum;
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

}
