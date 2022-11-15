<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){ //document는 생략가능.
	$("#btn").click(function(){
		if($("#name").val()==""){
			alert("이름 입력!")
			return
		}
		if($("#age").val()==""){
			alert("나이 입력!")
			return
		}
		//관심분야 선택안하면 선택하라는 alert, 길이로 체크해봄. 접근은 네임이나 타입으로도 가능.
		if($("input:checkbox[name = 'hobby']:checked").length==0){
			alert("관심분야 선택!"); //JS는 세미콜론 해도되고 안해도됨. 자바는 필수.
			return
		}
		$("#frm").submit()
	})
})

</script>
</head>
<body>
<form action="formResult2.jsp" id="frm">
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
<input type="button" value="jquery전송" id="btn">
</form>
</body>
</html>