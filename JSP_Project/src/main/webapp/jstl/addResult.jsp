<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int sum = num1 + num2 ;
%>
<body>
덧셈결과 : <%=num1+num2%> <br />
덧셈 : <%=sum%> <br />
<%
	if(sum%2 == 0){
%>
		<%=sum%> : 짝수
<%
	} else{
%>
		<%=sum%> : 홀수
<%
	}
%>
</body>
</html>