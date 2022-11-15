package com.jqueryAddress;

import java.util.ArrayList;

public interface JAddressDAO {
	
	public void insert(AddressVO avo); // �߰�

	public ArrayList<AddressVO> list(); // ��ü���� (�˻��ƴ�)
	public ArrayList<AddressVO> searchList(String field, String word); // ��ü���� (�˻�)

	public AddressVO findByNum(int num);	// �󼼺���

	public int getCount(); // ���� (�˻��ƴ�)
	public int getCount(String field, String word); // ���� (�˻�)
	
	public void update(AddressVO avo);	// ����
	
	public void delete(int num);	// ����
	
	// �����ȣ �˻�
	public ArrayList<ZipCodeVO> getZipcode(String dong);
	
}
