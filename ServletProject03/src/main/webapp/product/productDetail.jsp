<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>상품 상세보기</h1>
	</div>
</div>
<div class="container mt-3">
	<div class="media">
		<img src="/upload/${p.filename}" class="align-self-start mr-3"
			style="width: 400px">
		<div class="media-body">
			<table class="table table hover">
				<tr>
					<td><b>상품명</b></td>
					<td>${p.pname}</td>
				</tr>
				<tr>
					<td><b>상품 가격</b></td>
					<td>${p.unitPrice}</td>
				</tr>
				<tr>
					<td><b>상품 설명</b></td>
					<td>${p.description}</td>
				</tr>
			</table>
		</div>
	</div>

</div>
<%@ include file="../include/footer.jsp"%>