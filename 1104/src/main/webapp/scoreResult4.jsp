<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
%> <!-- 한글깨지지않게 처리 -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="sb" class="com.exam.ScoreBean"></jsp:useBean> <!-- 자바파일에 이름(아이디 임의)을 붙여서 게터세터 이용해 값을 가져오거나 저장. -->
<jsp:setProperty property="*" name="sb"/> <!-- 모두 셋 할거면 * -->
<body>

이름 : <jsp:getProperty property="name" name="sb"/><br/>
국어 : <%=sb.getKor() %><br/> <!-- 같은 뜻, 간결코드 -->
영어 : <%=sb.getEng() %><br/>
수학 : <%=sb.getMath() %><br/>
총점 : <%=sb.getTotal() %><br/>
평균 : <%=sb.getAvg() %><br/>
학점 : <%=sb.getGrade() %><br/>

</body>
</html>