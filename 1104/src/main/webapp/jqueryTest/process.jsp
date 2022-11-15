<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String method = request.getParameter("method");
    String str = "[처리결과]<br/>";
    str += "ID : " + id +"<br/>";
    str += "PWD : " + pwd + "<br/>";
    str += "method : " + method + "<br/>";
    out.println(str);
%>