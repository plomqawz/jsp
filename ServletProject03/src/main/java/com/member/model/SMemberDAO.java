package com.member.model;

import java.util.ArrayList;

public interface SMemberDAO {
	public void memberJoin(SMemberDTO member); // 추가
	public ArrayList<SMemberDTO> getMember(); // 전체보기
	public int memberDelete(String userid); // 삭제
	public int memberUpdate(SMemberDTO member); // 수정
	public SMemberDTO findById(String userid); // 상세보기
	public int memberCount(); // 회원수
	public String memberIdCheck(String userid); // 아이디 중복확인
	public SMemberDTO memberLoginCheck(String userid, String pwd); // 로그인
}
