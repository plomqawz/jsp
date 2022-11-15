<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#send").click(function(){ // 검색버튼 클릭.
		sendIt();
	}) //send
	
	$("#dong").keydown(function(e){ // 동이름 입력하고 엔터 인식.
		if(e.keyCode == 13){
			sendIt();
		}
	}) // keydown
	
	var sendIt = function(){
		if ($("#dong").val()==""){
			alert("동이름을 입력하세요.")
			return false;
		}
			$.getJSON("zipProcess.jsp",
			{"dong" : $("#dong").val()},
			function(resp){
				// alert(resp);
				var str = "<table>"
				$.each(resp, function(key, val){
					str += "<tr>"
					
					str += "<td>" + val.zipcode + "</td>"
					str += "<td>" + val.sido + "</td>"
					str += "<td>" + val.gugun + "</td>"
					str += "<td>" + val.dong + "</td>"
					str += "<td>" + val.bunji + "</td>"
					
					str += "</tr>"
				})
				
				str += "</table>"
				$("#result").html(str);
			}
		) // getJSON
	}
	
	$("#result").on("click", "tr", function(){
		var address = $("td:eq(1)", this).text() + " " +
						 			 $("td:eq(2)", this).text() + " " +
									 $("td:eq(3)", this).text() + " " +
									 $("td:eq(4)", this).text();
		// alert(address)
		$(opener.document).find("#zipcode").val($("td:eq(0)", this).text()); // var() 안에 안쓰면 겟 값 있으면 셋
		$(opener.document).find("#addr").val(address)
		self.close()
	})


})//document

</script>
</head>
<body>
	<table>
		<tr>
			<td>동이름 입력 : <input type="text" name="dong" id="dong"/>
			<input type="button" value="검색" id="send"/>
		</tr>
	</table>
<div id="result"></div>
</body>
</html>