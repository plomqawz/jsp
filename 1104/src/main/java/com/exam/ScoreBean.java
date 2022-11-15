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
 
// 총점
public int getTotal() {
	return kor+eng+math; //total 변수 만들지 말고 있는 변수만 이용.
}

// 평균
public float getAvg() {
	/*
	 * double avg=(kor+eng+math)/3.0f; return avg;
	 */
  return (kor+eng+math)/3.0f;
}

// 학점
public String getGrade() {
	String grade="";
	switch((int)((int)getAvg()/10)){ // 나누는 기준 90~99 , 80~89, 70~79 공통점 : 10으로 나누었을 때 몫이 9, 8, 7 인 점을 이용.
	//switch(getTotal()/3/10) 도 같음.
	case 9:grade="A"; break; // break 문 넣어주기.
	case 8:grade="B";break;
	case 7:grade="C";break;
	default:grade="F";
	} 
	return grade;
}


}
