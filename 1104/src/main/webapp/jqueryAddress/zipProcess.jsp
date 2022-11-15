<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.jqueryAddress.ZipCodeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String dong = request.getParameter("dong");
	// String dong = "부전동";
	JAddressDAO dao = JAddressDAOImpl.getInstance(); // JSON>JAVA 형태로 바꿈. 여러 라이브러리 존재. JSON simple 사용해봄.
	ArrayList<ZipCodeVO> zarr = dao.getZipcode(dong);
	// System.out.println(zarr.size());  // 부전동 검색했을 때 콘솔에 5 출력.
	
	// java zarr ==> json
	JSONArray jsonarr = new JSONArray();
	for(ZipCodeVO z : zarr){
		JSONObject obj = new JSONObject();
		obj.put("zipcode", z.getZipcode());
		obj.put("sido", z.getSido());
		obj.put("gugun", z.getGugun());
		obj.put("dong", z.getDong());
		obj.put("bunji", z.getBunji());
		jsonarr.add(obj);
	}
	out.println(jsonarr.toString());
%>


