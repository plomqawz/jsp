<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.member.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userid = request.getParameter("userid");
	MemberDAO dao = MemberDAOImpl.getInstance();
	dao.memberDelete(userid);
	ArrayList<MemberDTO> arr = dao.memberList();
	int count = dao.getCount(); // 필요한건 arr, count 그런데 2개를 리턴할 수 없으니 아우르는 obj 객체로 묶어야함.

	// 자바 > json
	
	// main (루트)
	JSONObject mainObj = new JSONObject();
	
	// arr > JSON
	JSONArray jarr = new JSONArray();
	for(MemberDTO member : arr){
		String mode = member.getAdmin()==0?"일반회원":"관리자";
		JSONObject obj = new JSONObject();
		obj.put("name", member.getName());
		obj.put("userid", member.getUserid());
		obj.put("email", member.getEmail());
		obj.put("phone", member.getPhone());
		obj.put("pwd", member.getPwd());
		obj.put("admin", mode);
		jarr.add(obj);
	}
	
	// 개수
	JSONObject countObj = new JSONObject();
	countObj.put("count", count);
	
	// 메인에 추가, 메인만 리턴.
	mainObj.put("jarrObj", jarr); // 쉼표 앞 임의로 설정가능. 안헷갈리게 한것뿐.
	mainObj.put("countObj", countObj);
	// 출력해야 화면에 보인다.
	out.print(mainObj.toString());
	
%>