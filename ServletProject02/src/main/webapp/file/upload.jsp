<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="upload.do" method="post" enctype="multipart/form-data">
<!-- 파일업로드할때는 메소드 반드시 포스트. 기본 인코딩타입 알고있기. -->
	글쓴이 : <input type="text" name="name" /><br/>
	제목 : <input type="text" name="title" /><br/>
	파일 : <input type="file" name="uploadFile" /><br/>
	<input type="submit" value="전송" />
</form>

</body>
</html>