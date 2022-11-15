<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="ad" class="com.address.Address"></jsp:useBean>
<jsp:setProperty property="*" name="ad" />

<%
	AddressDAO dao = AddressDAO.getInstance();
	dao.addrUpdate(ad);
	response.sendRedirect("list.jsp"); // 수정한 것 리스트화면으로 리디렉션. 없으면 흰페이지.
%>