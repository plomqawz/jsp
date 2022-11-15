<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% //스크립트 릿 (자바문법과 같음, 알려줘야함)
//객체 == 속성 + 행위(기능)
//		멤버변수 + 메소드(함수) ~ 예시 document.write , console.log
String name = request.getParameter("name"); // string 넣고 string 받음 잘 보기
String addr = request.getParameter("addr");
%>
이름 : <% out.println(name); %><br/>
주소 : <% out.println(addr);  %>
<hr/>

이름 : <%=name %>
주소 : <%=addr %>
</body>
</html>