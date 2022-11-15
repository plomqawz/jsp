package com.jqueryAddress;

import java.util.ArrayList;

public interface JAddressDAO {
	
	public void insert(AddressVO avo); // 추가

	public ArrayList<AddressVO> list(); // 전체보기 (검색아님)
	public ArrayList<AddressVO> searchList(String field, String word); // 전체보기 (검색)

	public AddressVO findByNum(int num);	// 상세보기

	public int getCount(); // 개수 (검색아님)
	public int getCount(String field, String word); // 개수 (검색)
	
	public void update(AddressVO avo);	// 수정
	
	public void delete(int num);	// 삭제
	
	// 우편번호 검색
	public ArrayList<ZipCodeVO> getZipcode(String dong);
	
}
