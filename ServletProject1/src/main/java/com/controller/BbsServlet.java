package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String name=req.getParameter("name");
			String subject=req.getParameter("subject");
			String memo=req.getParameter("memo");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<body>");
			out.print("<b> 이름 : </b>" +name +"<br />");
			out.print("<b> 제목 : </b>" +subject +"<br />");
			out.print("<b> 내용 : </b>" +memo +"<br />");
			out.print("</body>");
			out.print("</head>");
			out.print("</html>");
		}
}
