<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userid = (String)session.getAttribute("sUserid");

	MemberDAO dao = MemberDAOImpl.getInstance();
	dao.memberDelete(userid);
	session.invalidate();
	response.sendRedirect("loginForm.jsp");
%>