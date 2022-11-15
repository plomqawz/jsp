<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check(){
	//alert("확인")
	//dom 형태로 빈칸이 무엇인지 찾음
	if(document.getElementById("name").value==""){
		alert("이름을 입력하세요.")
		return //끊는역할. 없으면 뒤의 알림창 모두 뜸. 다른방법 else if 쓰는 방법. return을 더 많이 쓴다.
	}
	if(document.getElementById("kor").value==""|| isNaN(document.getElementById("kor").value)){
		alert("숫자로 국어점수를 입력하세요.")
		document.getElementById("kor").value=""
		return
	}
	if(document.getElementById("eng").value==""|| isNaN(document.getElementById("eng").value)){
		alert("영어점수를 입력하세요.")
		document.getElementById("eng").value=""
		return
	}
	if(document.getElementById("math").value==""|| isNaN(document.getElementById("math").value)){
		alert("수학점수를 입력하세요.")
		document.getElementById("math").value=""
		return
	}
	document.getElementById("frm").submit() // 입력했는데 제출동작 없어서 추가.
}
</script>
</head>
<body>
<form action="scoreResult.jsp" id="frm">
이름 : <input type="text" name="name" id="name"> <br>
국어 : <input type="text" name="kor" id="kor"> <br>
영어 : <input type="text" name="eng" id="eng"> <br>
수학 : <input type="text" name="math" id="math"> <p>
<input type="button" value="button전송" onclick="check()"> <!-- 웹페이지 검사에서 js오류확인 -->
</form>
</body>
</html>