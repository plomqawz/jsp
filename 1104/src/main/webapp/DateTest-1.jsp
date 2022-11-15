<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %> <!-- 캘린더 임포트. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
Calendar ca=Calendar.getInstance(); // 추상클래스라 new생성자로 인스턴스나 객체생성 불가. 임포트해야함.
String day="";
// String day2="";
switch(ca.get(Calendar.DAY_OF_WEEK)){
case 1:day="일"; break;
case 2:day="월"; break;
case 3:day="화"; break;
case 4:day="수"; break;
case 5:day="목"; break;
case 6:day="금"; break;
case 7:day="토"; break;
}
String[] arr = {"일","월","화","수","목","금","토"};
// day2=arr[ca.get(Calendar.DAY_OF_WEEK)-1]; * / 인덱스 0부터 시작하므로 -1. */
%>
</head>
<body>
<!-- 오늘은 2022년 11월 4일 금요일 -->
오늘은 <%=ca.get(Calendar.YEAR) %>년
<%=ca.get(Calendar.MONTH)+1%>월 <!-- 컴퓨터입장에서 0번째가 1이라 +1. -->
<%=ca.get(Calendar.DATE) %>일
<%=ca.get(Calendar.DAY_OF_WEEK) %>요일 <!-- int형 반환이라 6요일이라고 뜸. 2가지 방법 : switch문 사용 또는 배열사용-->
<hr/>
switch 요일 : <%=day %><br/>
배열요일 : <%=arr[ca.get(Calendar.DAY_OF_WEEK)-1]%>
</body>
</html>