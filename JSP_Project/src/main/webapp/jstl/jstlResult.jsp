<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${param.id} 가 좋아하는 색깔은 ${param.color}
<hr />
<c:choose>
	<c:when test="${param.color=='orange'}">
		<c:set var="c" value="노란색" />
	</c:when>
</c:choose>

<c:set var="name" value="${param.id}" />
<c:if test="">
</c:if>

<c:set var="name" value="${param.id}" />
${name} 좋아하는 색깔은 ${c}
</body>
</html>