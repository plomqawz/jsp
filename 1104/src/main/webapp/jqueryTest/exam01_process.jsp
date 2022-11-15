<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8"); // 한글안깨지게
	String id = request.getParameter("id"); // 한번만 쓸거라면 변수담을필요없이 바로 % 안에 request...
	String pwd = request.getParameter("pwd");
%>
ID : <%=id%> <br>
PWD : <%=pwd%>
</body>
</html>