package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.CommentDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CommentListController
 */
@WebServlet("/board/commentlist")
public class CommentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    int bnum = Integer.parseInt(request.getParameter("bnum"));
	    SBoardDAO dao = SBoardDAOImpl.getInstance();
	    ArrayList<CommentDTO>  carr = dao.findAllComment(bnum);
	    int count = dao.commentCount(bnum);
	    // gson.jar
	    Gson gson=new Gson();
	    Map<String, Object> hm = new HashMap<String, Object>();
	    hm.put("jarr", carr);
	    hm.put("count", count);
	    String jsonStr = gson.toJson(hm); // gson에는 객체를 Json으로 바꾸는 함수 사용해서 여태처럼 put 할필요 없음.
	    response.setContentType("application/json;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.print(jsonStr.toString());
	    
	    
	    
	    // json-simple.jar
/*	     //main
	     
	     JSONObject mainObj = new JSONObject();*/
	    
	    // carr(java)  ==> json
	    //댓글내용	
/*	    JSONArray jarr = new JSONArray();
	    for(CommentDTO comm : carr){
	    	JSONObject obj = new JSONObject();
	    	obj.put("userid", comm.getUserid());
	    	obj.put("cnum", comm.getCnum());
	    	obj.put("bnum",comm.getBnum());
	    	obj.put("regdate",comm.getRegdate());
	    	obj.put("msg",comm.getMsg());
	    	jarr.add(obj);
	    }
	    //개수
	    JSONObject countObj = new JSONObject();
	    countObj.put("count", count);
	    
	    //메인에 추가 (데이터 와 개수)
	      mainObj.put("dataObj", jarr);
	      mainObj.put("countObj", countObj);
	    out.println(mainObj.toString());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
