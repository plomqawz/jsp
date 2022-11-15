<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#getBtn").on("click", function(){
		$.get( "process.jsp",
				{
					id : $("#id").val(),
					pwd : $("#pwd").val(),
					method : "get"
				}
		) // get (아까와 달리 인자 2개)
		.done(function(resp){ // 끝나고 나면 하라는 뜻.
			$("#result").html(resp)
		}) 
	}) // getBtn
	
	$("#postBtn").on("click",function(){
		$.post( "process.jsp",
				{
					id : $("#id").val(),
					pwd : $("#pwd").val(),
					method : "post"
				}
		) // post
		.done(function(resp){
			$("#result").html(resp)
		})
	}) // postBtn
	
	$("#ajaxBtn").on("click",function(){
		$.ajax({
			type : "get",
			url : "process.jsp",
			data : {
				id : $("#id").val(),
				pwd : $("#pwd").val(),
				method : "ajax"
			}
		}) // ajax
		.done(function(resp){
			$("#result").html(resp);
		})
		.fail(function(e){
			alert(e + "error")
		})
	}) // ajaxBtn
	
}) // document

</script>
</head>
<body>
	<h3>exam03</h3><p>
	ID : <input type="text" id="id" name="id"><br>
	PWD : <input type="password" id="pwd" name="pwd"><p>
	<button type="button" id="getBtn">get 전송</button>
	<button type="button" id="postBtn">post 전송</button>
	<button type="button" id="ajaxBtn">ajax 전송</button>

<hr/>
<div id="result">
</div>
</form>
</body>
</html>