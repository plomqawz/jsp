<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>상품 리스트</h1>
	</div>
</div>

<div class="container">
	<div class="row">
		<c:forEach items="${products}" var="p">
			<div class="col-4" style="width: 400px">
			
					<img class="card-img-top" src="/upload/${p.filename}" alt="Card image" style="width: 300px; height:200px">
					<div class="card-body">
						<h4 class="card-title">${p.pname}</h4>
						<p class="card-text">${p.description}</p>
						<a href="/product/pdetail?num=${p.productId}" class="btn btn-primary">상세보기</a>
					</div>
				
			</div>

		</c:forEach>

	</div>


</div>



<%@ include file="../include/footer.jsp"%>