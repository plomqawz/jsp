<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 request.setCharacterEncoding("UTF-8");
 %>
 <jsp:useBean id="ad" class="com.address.Address"></jsp:useBean>
 <jsp:setProperty property="*" name="ad"/> <!-- 슬래시가 닫는다는뜻 -->
 
 <%
 AddressDAO dao=AddressDAO.getInstance();
 dao.addrInsert(ad); //추가
 response.sendRedirect("list.jsp"); // 없을 땐 추가해도 백지. list.jsp로 돌림.
 %>
 