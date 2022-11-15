<%@page import="com.address.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script>
	function searchCheck() {
		if (document.getElementById("word").value == "") {
			alert("검색어를 입력하세요.");
			document.getElementById("word").focus();
			return;
		}
		document.getElementById("sfrm").submit();
	}
</script>

<%
request.setCharacterEncoding("UTF-8");
String field = ""; // String "" 객체가 만들어짐.
String word = "";
if (request.getParameter("word") != null) { // 검색
	field = request.getParameter("field");
	word = request.getParameter("word");
}
AddressDAO dao = AddressDAO.getInstance();
ArrayList<Address> arr = dao.addressList(field, word);
int count = dao.getCount(field, word);
%>
</head>
<body>
	<div class="container">
		<div align="right">
			<a href="insert.jsp">추가하기</a> / <span
				onclick="location.href='list.jsp'">전체보기</span>
				<br /><br />
		</div>
		<h3>전체보기(<%=count%>)</h3>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>주소</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Address ad : arr) {
				%>
				<tr>
					<td><%=ad.getNum()%></td>
					<td><a href="detail.jsp?num=<%=ad.getNum()%>"><%=ad.getName()%></a>
					</td>
					<td><%=ad.getZipcode()%></td>
					<td><%=ad.getTel()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<form action="list.jsp" id="sfrm">
			<select name="field">
				<option value="name">이름</option>
				<option value="addr">주소</option>
			</select> <input type="text" name="word" id="word"> <input
				type="button" value="검색" onclick="searchCheck()">
		</form>
	</div>
</body>
</html>