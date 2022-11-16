package com.addr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.model.AddrDTO;
import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOImpl;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/addr/update.addr")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AddrDTO address = new AddrDTO();
		address.setAddr(request.getParameter("addr"));
		address.setName(request.getParameter("name"));
		address.setNum(Integer.parseInt(request.getParameter("num")));
		address.setTel(request.getParameter("tel"));
		address.setZipcode(request.getParameter("zipcode"));
		
		SAddrDAO dao = SAddrDAOImpl.getInstance();
		dao.addrUpdate(address);
		
		response.sendRedirect("list.addr");
		//response.sendRedirect("view.addr?num="+num);
		
	}

}
