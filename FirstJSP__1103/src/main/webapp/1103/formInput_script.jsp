<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check(){
	// * 이름, 나이 공백인지 검사
/* 	if(document.getElementById("name").value==""){
		alert("이름을 입력하세요.")
		return
		} */
		// js버전업하면서 쿼리셀렉터로 해도 같은 결과. #은 아이디를 말한다.
		if(document.querySelector("#name").value==""){
			alert("이름을 입력하세요.")
			return
		}
	if(document.getElementById("age").value==""){
		alert("나이를 입력하세요.")
		return
		}
	
	// * 관심분야 선택 안하면 선택하라고 alert (복수라 elements, id 아니라 name으로 구분)
	var chk_obj = document.getElementsByName("hobby")
	// alert(chk_obj.length) //관심분야 개수세서 알림창.
	var checked = false // if 문 들어갔으면 true, 안들어갔으면 false로 설정해서 입력값 유무의 확인
   // false 대신 0, true 대신 1 넣어도 됨.
	for(i=0;i<chk_obj.length;i++){
	if (chk_obj[i].checked){
		//alert(chk_obj[i].value)
		checked = true
	}
	}
	if(checked == false){
		alert("관심분야 선택")
		return
	}
	document.getElementById("frm").submit()
}

</script>
</head>
<body>
<form action="formResult.jsp" method="get" id="frm">
이름 : <input type = "text" name="name" id="name"> <br> 
나이 : <input type = "text" name="age" id="age"> <br>
성별 : 
<!--  -->
<input type = "radio" name="gender" value="남자" checked>남자
<input type = "radio" name="gender" value="여자">여자
<br>
관심분야 : 
<input type = "checkbox" name="hobby" value="운동"> 운동
<input type = "checkbox" name="hobby" value="게임"> 게임
<input type = "checkbox" name="hobby" value="등산"> 등산
<input type = "checkbox" name="hobby" value="영화"> 영화
<br>
직업 : 
<select name="job">
<option value="학생" checked>학생</option>
<option value="공무원">공무원</option>
<option value="회사원">회사원</option>
<option value="기타">기타</option>
</select>
<br>
<input type="button" value="버튼전송" onclick="check()">
</form>
</body>
</html>