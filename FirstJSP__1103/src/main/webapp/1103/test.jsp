<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="testResult.jsp" method="get"> <!-- 폼태그 : 폼태그 안의 요소를 서버에 전달(디폴트 자기자신) , 액션:갈 곳 정함 , 메소드(디폴트 get) post 쓰면 주소창에 입력한 값 안보임-->
이름 : <input type = "text" name="name"> <br> <!-- 구분위해 name 요소 추가 -->
주소 : <input type = "text" name="addr"> <p>
<input type="submit" value="전송">
</form>
</body>
</html>