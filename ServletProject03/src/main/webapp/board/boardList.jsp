<%@page import="com.board.model.SBoardDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.model.SBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<script>
$(function(){
	$("#writeBtn").click(function(){
		if(${empty sessionScope.suser}){
			alert("로그인 하세요");
			location.href="../member/login"
			return;
		} // if
		location.href="write"
	}) // writeBtn
}) // funtion
</script>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Board List(${count})</h1>
	</div>
</div>

<button type="button" class="btn btn-primary" id="writeBtn">글쓰기</button>

<div class="container">
<table class="table table-hover">
<thead>
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${boards}" var="b">
	<tr>
	<td>${b.num}</td>
	<td>${b.userid}</td>
	<td><a href="boardDetail?num=${b.num}">${b.subject}</a></td>
	<td>${b.readcount}</td>
	<td>${b.regdate}</td>
	</tr>
</c:forEach>
</tbody>
</table>

</div>


<%@ include file="../include/footer.jsp"%>