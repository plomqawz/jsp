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
	$("#getBtn").click(function(){
		$.get(
				"process.jsp", // 가져갈 서버페이지
				{
					"id" : $("#id").val(), // 가지고 갈 값
					"pwd" : $("#pwd").val(),
					"method" : "get"
				},
				function(resp){ // 콜백함수. resp:변수. 입력한 값이 resp에 있음.
					 // alert(resp)
					$("#result").html(resp);
				}
				) //get 3개 들어감.
	}) // getBtn click
	
	$("#postBtn").click(function(){
		$.post(
				"process.jsp",
				{
					"id" : $("#id").val(),
					"pwd" : $("#pwd").val(),
					"method" : "post"
				},
				function(resp){ // 콜백함수. resp:변수. 입력한 값이 resp에 있음.
					 // alert(resp)
					$("#result").html(resp);
				}
			)// post
	})// postBtn click	
	
	$("#ajaxBtn").click(function(){
		$.ajax({
			type : "get",
			url : "process.jsp",
			data : {
				id : $("#id").val(),
				pwd : $("#pwd").val(),
				method : "ajax"
			},
			success : function(resp){
				$("#result").html(resp);
			},
			error : function(e){
				alert(e+"error")
			}
		}) // ajax
	}) // ajaxBtn click
	
	$("#ajaxBtn_on").on("click", function(){ // (on 함수 : click과 연결함수)
		$.ajax({	
			type : "get",
			url : "process.jsp",
			data : {
				id : $("#id").val(),
				pwd : $("#pwd").val(),
				method : "ajax_on"
			},
			success : function(data){
				$("#result").html(data)
			},
			error : function(e){
				alert(e+"error")
			}
		}) // ajax
	}) // ajaxBtn on


}) // document

</script>
</head>
<body>
	ID : <input type="text" id="id" name="id"><br>
	PWD : <input type="password" id="pwd" name="pwd"><p>
	<button type="button" id="getBtn">get 전송</button>
	<button type="button" id="postBtn">post 전송</button>
	<button type="button" id="ajaxBtn">ajax 전송</button>
	<button type="button" id="ajaxBtn_on">ajax_on 전송</button>
<hr/>
<div id="result">
</div>
</form>
</body>
</html>