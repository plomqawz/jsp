<%@page import="com.member.dao.MemberDAO"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = MemberDAOImpl.getInstance();
	// 로그인체크
	int flag = dao.loginCheck(userid, pwd);
	if(flag==0 || flag==1){
		session.setAttribute("sUserid", userid); // 원하는 값(문자열 아닌 객체도 가능) 저장.(키와 밸류처럼 사용) 세션 기본값 true. 
	}
	
	out.println(flag);
%>