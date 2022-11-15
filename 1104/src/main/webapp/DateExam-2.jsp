<%@ page import="com.exam.DateBean" %><!-- 자바와 뷰 구분해서 자주 사용. 유지보수 위해. 작성한 자바코드 임포트함. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 스크립트가 아닌 자바로 표현하기. com.exam 작성. -->

<%
DateBean bean=new DateBean(); 
%>
<%=bean.getToday()%>