$(document).ready(function(){
	
	var exp =/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/ // 정규식 패턴
	
	$("#sendBtn").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}
		
		if($("#userid").val()==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus();
			return false;
		}
		
		if($("#pwd").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#pwd").focus();
			return false;
		}
		
		if($("#pwd").val() != $("#pwd_check").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd_check").focus();
			return false;
		}
		
		if($("#email").val()==""){
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}
		
		/* if(!$("#phone").val().match(exp)){ // 방법 1. match 함수 이용, ! : 아니라면
			alert("전화번호의 형식이 아닙니다.");
			$("#phone").focus();
			return false;
		} */
		
		if(!exp.test($("#phone").val())){ // 방법 2. test 함수 이용, ! : 아니라면
			alert("전화번호의 형식이 아닙니다.");
			$("#phone").focus();
			return false;
		}
		
		$("#frm").submit()
		
		
	}) // sendBtn
	
	// (ㅁ-ㅁ)/ : "idCheckBtn" 클릭하면 팝업인 idCheck.jsp 띄우기
	$("#idCheckBtn").click(function(){
		window.open("idCheck.jsp","","width=600 height=300")
	}) // idCheckBtn
	
	// idUseBtn 클릭하여 유효성검사.
	$("#idUseBtn").click(function(){
		if($("#userid").val()==""){
			alert("아이디를 입력하세요.")
			return;
		}
		
		$.ajax({
			type : 'post',
			url : "idCheckPro.jsp",
			data : {"userid" : $("#userid").val()},
			success : function(resp){
				// alert(resp.trim().length); // trim을 쓰지 않으면 공백까지 모두 인식해서 큰 숫자 10, 11 나옴. trim 쓰면 2, 3 나옴.
				if(resp.trim()=="yes"){
					alert("사용가능한 아이디입니다.")
					$(opener.document).find("#userid").val($("#userid").val())
					// 해석 : 사용가능한 아이디라면 나를 불러준 문서에서 userid 아이디를 가진 곳을 찾아 $("#userid").val() 를 그 곳에 세팅해준다.
					self.close()
				} else {
					alert("사용 불가능한 아이디입니다.")
					$("#userid").val("") // 입력창을 지우고,
					$("#userid").focus() // 입력창 커서가 깜빡이게 한다.
				}
			},
			error : function(e){
				alert(e + "error");
			}
		}) // ajax
		
	}) // idUseBtn

	
}) // document

// 삭제 기능 : 비동기함수 이용, 숫자와 테이블데이터만 바뀌게.
function del(userid, mode){
	if(mode == "관리자"){ // 관리자는 삭제못하는 기능.
		alert("관리자는 삭제할 수 없습니다.")
		return; // 더 진행되지 않게 돌아감(종료함).
	}
	
	if(confirm("정말 삭제할까요?")){
		$.getJSON("memberDeletePro.jsp",
						  {"userid" : userid},
						  function(resp){
							// alert(resp.countObj.count) // 줄어든 개수 알림창.
							
							var str=""
							$.each(resp.jarrObj, function(key, val){ // each 문으로 반복하며 출력.
								str+= "<tr>"
								str+= "<td>"+val.name+"</td>" // obj.put("asdf",~~~) 의 asdf 가 val.asdf 이다.
								str+= "<td>"+val.userid+"</td>"
								str+= "<td>"+val.email+"</td>"
								str+= "<td>"+val.phone+"</td>"
								str+= "<td>"+val.admin+"</td>"
								str+= "<td><a href=javascript:del('" + val.userid + "','" +val.admin+ "')>삭제</a></td>"
								// 삭제 후의 리스트에서도 삭제 활성화 위해 List 삭제의 a태그를 가져오되, 따옴표 안이므로 "" 없애도 된다.
								// a 태그 가져올 때 <%=member.getUserid()%> 는   " + val.userid + " 로 바꿈.
								// ','" +val.admin+ "': 삭제 후 리스트에서도 관리자 삭제 못하게 인자값 넘김.
								str+="</tr>"
							}) // each
							
							$("table tbody").html(str);
							$("#cntSpan").text(resp.countObj.count) // 줄어든 개수를 cntSpan 위치에 배치.
						} // function
				); // getJSON		
		}// if
	}// del