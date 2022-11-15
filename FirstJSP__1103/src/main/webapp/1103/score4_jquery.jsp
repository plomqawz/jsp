<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> <!-- 한 스크립트에 같이 쓰지 않기. -->
<script>
$(document).ready(function(){ // 사용할 함수를 ready()안에 선언. 이름 없으면 익명함수. 호출하지 않고 바로 작성.
   $("#btn").click(function(){
	if($("#name").val()==""){
		alert("이름을 입력하시오.")
		return
	 }
	if($("#kor").val()=="" || isNaN($("#kor").val() )){
		alert("국어점수 입력하시오.")
		$("#kor").val("")
		return
	}
	if($("#eng").val()=="" || isNaN($("#eng").val() )){
		alert("영어점수 입력하시오.")
		$("#eng").val("")
		return
	}
	if($("#math").val()=="" || !$.isNumeric($("#math").val() )){ // !$.isNumeric() : 숫자가 아니라면
		alert("수학점수 입력하시오.")
		$("#math").val("")
		return
	}
	$("#frm").submit()
  })
})
//name 선언위치가 사용위치보다 뒤쪽이기 때문에 작동안함.  2가지 방법. 선언뒤에 스크립트쓰거나 앞에 $(document).ready() 쓰고 괄호안에 사용할 함수 써버리기.
/* if ($("#name").val() == ""){ 
alert("이름을 입력하세요.")} */
</script>
</head>
<body>
<form action="scoreResult.jsp" id="frm">
이름 : <input type="text" name="name" id="name"> <br>
국어 : <input type="text" name="kor" id="kor"> <br>
영어 : <input type="text" name="eng" id="eng"> <br>
수학 : <input type="text" name="math" id="math"> <p>
<input type="button" value="jquery전송" id="btn">
</form>
</body>
</html>