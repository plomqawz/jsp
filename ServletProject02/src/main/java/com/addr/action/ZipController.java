package com.addr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOImpl;
import com.addr.model.ZipDTO;

/**
 * Servlet implementation class ZipController
 */
@WebServlet("/addr/zip.addr")
public class ZipController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addr_zip.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dong = request.getParameter("dong");
		SAddrDAO dao = SAddrDAOImpl.getInstance();
		ArrayList<ZipDTO> zarr = dao.addrZipRead(dong);
		
		JSONArray jarr = new JSONArray();
		for (ZipDTO z : zarr) {
			JSONObject obj = new JSONObject();
			obj.put("zipcode", z.getZipcode());
			obj.put("sido", z.getSido());
			obj.put("gugun", z.getGugun());
			obj.put("dong", z.getDong());
			obj.put("bunji", z.getBunji());
			jarr.add(obj);
		}
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jarr.toString());
		
		
		
		
		
		
	}

}
