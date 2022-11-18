<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Board Detail</h1>
	</div>
</div>
<input type="hidden" id="num" value="${board.num}">
<table class="table table-hover">
	<tr>
		<th>글번호</th>
		<td>${board.num }</td>
		<th>조회수</th>
		<td>${board.readcount }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${board.userid }</td>
		<th>작성일</th>
		<td>${board.regdate }</td>
	</tr>
	<tr>
		<th>글제목</th>
		<td colspan="3">${board.subject }</td>
	</tr>
	<tr>
		<th>글내용</th>
		<td colspan="3">${board.content }</td>
	</tr>
</table>
<br />

<c:if test="${sessionScrope.suser.userid == board.userid}">
	<!-- 글쓴이에게만 수정 삭제 버튼이 보이게 한다. (로그인 세션=게시물 작성자) -->
	<button type="button" class="btn btn-primary"
		onclick="location.href='update?num=${board.num}'">수정</button>
	<button type="button" class="btn btn-secondary" id="delBtn">삭제</button>
</c:if>

<div class="container">
	<div class="form-group">
		<label for="comment">Comment:</label>
		<textarea class="form-control" rows="5" id="msg" name="text"></textarea>
	</div>
	<button type="button" class="btn btn-success" id="commentBtn">Comment
		add</button>
</div>
<div class="mt-3">
	댓글(<span class="cntSpan"></span>)
</div>
<div id="result"></div>

<script>
var init = function(){
	$.getJSON("commentlist",
		   {"bnum" :$("#num").val()},
		   function(resp){
			   var str ="<table class='table table-hover'>"
			   $.each(resp.jarr, function(key, val){
				   str+="<tr>"
				   str+="<td>"+val.msg+"</td>"
				   str+="<td>"+val.userid+"</td>"
				   str+="<td>"+val.regdate+"</td>"
				   str+="</tr>"
			   })
			   str +="</table>"
			   $("#result").html(str);
			   $(".cntSpan").text(resp.count)
		   }
	   )
}

	$("#commentBtn").click(function() {
		if ($("#msg").val() == "") {
			alert("메세지를 입력하세요")
			return;
		}
		$.ajax({
			type : "post",
			url : "commentInsert",
			data : {
				"msg" : $("#msg").val(),
				"bnum" : $("#num").val()
			},
			success : function(resp) {
				if (resp.trim() == 1) {//로그인 안됨
					alert("로그인하세요");
					location.href = "../member/login";
				} else {
					init();
					$("#msg").val("")
				}
			},
			error : function(e) {
				alert("error : " + e);
			}
		}) //ajax
	})//commentBtn
	
	init();
</script>

<%@ include file="../include/footer.jsp"%>