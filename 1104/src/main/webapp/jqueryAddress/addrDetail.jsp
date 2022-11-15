<%@page import="com.jqueryAddress.AddressVO"%>
<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@page import="com.address.AddressDAO"%>
<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	JAddressDAO dao = JAddressDAOImpl.getInstance();
	AddressVO avo = dao.findByNum(num);	
%>
<script>
	function zipRead(){
		window.open("zipCheck.jsp","","width=700 height=400")
	}
	function del(){
		if(confirm("삭제 하시겠습니까?")){
			location.href = "deleteProcess.jsp?num=<%=num%>";
		}
	}
</script>
</head>
<body>
<h3>JQUERY 상세보기</h3>
<form action = "updateProcess.jsp" method = "post">
 <table>
	<tr>
		<th>번호</th>
		<td><input type="text" name="num" value="<%=avo.getNum() %>" readonly="readonly"></td>
	</tr>
	<tr>
		<th>이름</th>
		<%-- <td><%=ad.getName() %></td> --%>
		<td><input type="text" name="name" value="<%=avo.getName() %>"></td>
	</tr>
<tr>
	<th>우편번호</th>
	<%-- <td><%=ad.getZipcode() %></td> --%>
	<td><input type="text" name="zipcode" id = "zipcode" value="<%=avo.getZipcode() %>" size = 7></td>
</tr>
<tr>
	<th>주소</th>
	<%-- <td><%=ad.getAddr() %></td> --%>
	<td><input type="text" name="addr" id = "addr" value="<%=avo.getAddr() %>" size = 50>
		<input type = "button" value = "검색" onclick = "zipRead()" />
	</td>
</tr>
<tr>
	<th>전화번호</th>
	<%-- <td><%=ad.getTel() %></td> --%>
	<td><input type="text" name="tel" value="<%=avo.getTel() %>"></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="수정">
		<input type="button" value="삭제" onclick="del()">
		<input type="reset" value="취소">
		<input type="button" value="전체보기 type button" onclick="location.href='addrList.jsp'">
		<button>전체보기</button> <!-- 타입버튼과 버튼의 차이? 기본적으로 submit 기능을 가짐. 옵션 안적어도 form 묶인 updateProcess 로 가므로 리다이렉트 List 로  옴.-->
		<!-- <button type="button"> 전체보기 </button> 이렇게 하면 submit 기능 없는 버튼. -->
	</td> 
</tr>
</table>
</form>
</body>
</html>