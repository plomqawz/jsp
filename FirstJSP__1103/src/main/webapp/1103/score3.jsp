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
		return false
	}
	if(document.getElementById("kor").value==""|| isNaN(document.getElementById("kor").value)){
		alert("숫자로 국어점수를 입력하세요.")
		document.getElementById("kor").value=""
		return false
	}
	if(document.getElementById("eng").value==""|| isNaN(document.getElementById("eng").value)){
		alert("영어점수를 입력하세요.")
		document.getElementById("eng").value=""
		return false
	}
	if(document.getElementById("math").value==""|| isNaN(document.getElementById("math").value)){
		alert("수학점수를 입력하세요.")
		document.getElementById("math").value=""
		return false
	}
	return true
}
</script>
</head>
<body>
<form action="scoreResult.jsp" id="frm" onsubmit = "return check()">
이름 : <input type="text" name="name" id="name"> <br>
국어 : <input type="text" name="kor" id="kor"> <br>
영어 : <input type="text" name="eng" id="eng"> <br>
수학 : <input type="text" name="math" id="math"> <p>
<input type="submit" value="submit전송">
<!-- 버튼 submit으로 바꾸면 무조건 넘김, onsubmit 추가, 리턴 폴스 추가, 마지막 트루하면 됨. 즉 submit 버튼인데도 js사용가능하다는 뜻. -->
</form>
</body>
</html>