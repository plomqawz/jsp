<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	// String hobby = request.getParameter("hobby"); // 값을 하나만 받아옴
	String[] hobby = request.getParameterValues("hobby"); //여러개 값을 배열형태로 받음.
	String tmp = ""; // 배열형태는 주소값을 가지므로, hobby 출력 시 주소값이 나옴. 따라서 tmp에 넣어 for문 돌린 뒤 tmp를 출력하면 정상출력됨.
	if (hobby != null) { // 체크박스 아무것도 선택하지 않았을 때 오류뜸. hobby가 null이 아니라면 if문 넣어 오류 없앰.
		for (int i = 0; i < hobby.length; i++) {
			tmp += hobby[i] + " ";
		}
	}
	String job = request.getParameter("job");
	%>
	이름 :
	<%
	out.println(name);
	%><br /> 주소 :
	<%
	out.println(age);
	%><br /> 성별 :
	<%
	out.println(gender);
	%><br /> 관심분야 :
	<%
	out.println(tmp);
	%><br /> 직업 :
	<%
	out.println(job);
	%><br />
	<hr />
	이름 :
	<%=name%><br /> 주소 :
	<%=age%><br /> 성별 :
	<%=gender%><br /> 관심분야 :
	<%=tmp%><br /> 직업 :
	<%=job%>
	<hr />
	직업 :
	<%=request.getParameter("job")%>
	<!-- 이렇게 쓸 수도 있음 -->
</body>
</html>