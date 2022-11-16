package com.addr.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.model.AddrDTO;
import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOImpl;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/addr/insert.addr")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addr_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddrDTO addr = new AddrDTO();
		addr.setAddr(request.getParameter("addr"));
		addr.setName(request.getParameter("name"));
		addr.setTel(request.getParameter("tel"));
		addr.setZipcode(request.getParameter("zipcode"));
		
		SAddrDAO dao = SAddrDAOImpl.getInstance();
		dao.addrInsert(addr);
		
		// 포워드 : 관계가 유지되면서 넘긴다, 주소가 바뀌지 않음 : 문제 새로고침때마다 추가됨
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("list.addr");
		 * rd.forward(request, response);
		 */
		
		// 그렇다면 관계를 끊는 리다이렉트 이용. : 주소가 바뀜
		response.sendRedirect("list.addr");
		
		// 그래서 입력값이 바뀌는 인서트 딜리트 업데이트 등은 리다이렉트로 뿌린다.
	
	}

}
