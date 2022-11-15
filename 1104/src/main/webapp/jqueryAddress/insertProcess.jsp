<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   	<%
   		request.setCharacterEncoding("UTF-8");
    %>
    
 <jsp:useBean id="avo" class="com.jqueryAddress.AddressVO"></jsp:useBean>
 <jsp:setProperty property="*" name="avo"/>
 
 <%
 JAddressDAO dao = JAddressDAOImpl.getInstance();
 dao.insert(avo);
 response.sendRedirect("addrList.jsp");
 %>