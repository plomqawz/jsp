<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="bbs" method="post">
이름 : <input type="text" name="name"><br>
제목 : <input type="text" name="subject"><br><br>
내용 : <textarea name="memo" rows=5 cols=50></textarea><br>
<input type="submit" value="전송">
</form>
</body>
</html>