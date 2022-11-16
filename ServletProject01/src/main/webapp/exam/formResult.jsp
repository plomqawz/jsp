<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Person</h3>
이름 : ${p.name} / <c:out value="${p.name}" /><br />
나이 : ${p.age} <br />
성별 : ${p.gender} <br />
취미 : ${p.hobby} <br />
직업 : ${p.job} <br />
<hr/>
<c:forEach items="${p.hobby}" var="h">
${h}
</c:forEach>
</body>
</html>