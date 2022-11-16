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
		
		// ������ : ���谡 �����Ǹ鼭 �ѱ��, �ּҰ� �ٲ��� ���� : ���� ���ΰ�ħ������ �߰���
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("list.addr");
		 * rd.forward(request, response);
		 */
		
		// �׷��ٸ� ���踦 ���� �����̷�Ʈ �̿�. : �ּҰ� �ٲ�
		response.sendRedirect("list.addr");
		
		// �׷��� �Է°��� �ٲ�� �μ�Ʈ ����Ʈ ������Ʈ ���� �����̷�Ʈ�� �Ѹ���.
	
	}

}
