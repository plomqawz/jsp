package com.exam;

public class ScoreBean {
 private String name;
 private int kor;
 private int eng;
 private int math;
 
 // getter, setter
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getKor() {
	return kor;
}
public void setKor(int kor) {
	this.kor = kor;
}
public int getEng() {
	return eng;
}
public void setEng(int eng) {
	this.eng = eng;
}
public int getMath() {
	return math;
}
public void setMath(int math) {
	this.math = math;
}
 
// ����
public int getTotal() {
	return kor+eng+math; //total ���� ������ ���� �ִ� ������ �̿�.
}

// ���
public float getAvg() {
	/*
	 * double avg=(kor+eng+math)/3.0f; return avg;
	 */
  return (kor+eng+math)/3.0f;
}

// ����
public String getGrade() {
	String grade="";
	switch((int)((int)getAvg()/10)){ // ������ ���� 90~99 , 80~89, 70~79 ������ : 10���� �������� �� ���� 9, 8, 7 �� ���� �̿�.
	//switch(getTotal()/3/10) �� ����.
	case 9:grade="A"; break; // break �� �־��ֱ�.
	case 8:grade="B";break;
	case 7:grade="C";break;
	default:grade="F";
	} 
	return grade;
}


}
