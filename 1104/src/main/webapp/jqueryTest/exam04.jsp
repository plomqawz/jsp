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
	$("#b1").click(function(){
		$.get("test.txt", function(resp, status){ // get 인자 중 가지고 갈 데이터 없으면 생략가능.
			var str = "데이터 : " + resp + " 상태 : " +status // ㅁㅁㅁ 상태값까지 알 수 있음.
			// alert(resp)
			$("#result").text(str);
		}) // get
	}) // b1
	
	$("#b2").click(function(){
		$.get("test.txt", function(resp){
			var d = JSON.parse(resp);
			// alert(d.length) // 개수만큼 알림창.
			var str = "";
			for(i=0; i<d.length; i++){
				console.log("picture : " + d[i].picture)
				str += "이름 : " + d[i].irum + "<br/>"
				str += "회원번호 : " + d[i].memberNumber + "<br/><br/>"
			} // for
			$("#result").html(str)
		}) // get 
	}) // b2
	
	$("#b3").click(function(){ // var d = JSON.parse(resp); 를 포함. 겟방식+파싱.
		var str="";
		$.getJSON("test.txt",function(resp){
			$.each(resp,function(key,val){ //제이쿼리의 for문 = each
				str +="회원번호 : " + val.memberNumber + "<br/>"
				str +="이름 : " + val.irum + "<br/>"
				str +="사진 : " + val.picture + "<br/><br/>"
			}) // each
			$("#result").html(str)
		}) // getJSON
	}) // b3
	
}) // document
</script>
</head>
<body>
<button  id="b1">결과1</button>
<button  id="b2">결과2</button>
<button  id="b3">결과3</button>
<div id="result"></div>
</body>
</html>