package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int sum=num1+num2;
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<b> sum : " +sum+ "</b>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}
}
