<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String name = request.getParameter("name");
int kor = Integer.parseInt(request.getParameter("kor")); // string 은 문자열, int 로 형변환하여 대입.
int eng = Integer.parseInt(request.getParameter("eng"));
int math = Integer.parseInt(request.getParameter("math"));
int total = kor+eng+math;
float avg = total /3.0f; // float 과 double 차이
// 평균이 90이상 A, 80이상 B, 70이상 C, 나머지 F
/* String grade; //if문이나 switch문으로 학점구현.
if (avg>=90){
	grade="A";
} else if (avg>=80){
	grade="B";
} else if (avg>=70){
	grade="C";
} else {grade="F";} */
String grade="";
switch((int)avg/10){ // 나누는 기준 90~99 , 80~89, 70~79 공통점 : 10으로 나누었을 때 몫이 9, 8, 7 인 점을 이용.
case 9:grade="A"; break; // break 문 넣어주기.
case 8:grade="B";break;
case 7:grade="C";break;
default:grade="F";
} 

/* int a=5;
long b=10; // int와 long 둘 다 4바이트로 크기는 같지만 정수보다 실수를 크다고 정의함.
b=a; // long<=int (작은것을 큰것에 대입하기 가능, 묵시적 캐스팅)
a=(int)b; // int=long (명시적(int)으로 캐스팅 해줘야함) */
%>

이름 : <%out.println(name); %><br/>
국어 : <%out.println(kor); %><br/>
영어 : <%out.println(eng); %><br/>
수학 : <%out.println(math); %><br/>
총점 : <%out.println(total); %><br/>
평균 : <%out.println(Math.round(avg)); %><br/>
학점 : <%out.println(grade);%>

<hr/>

이름 : <%=name %><br/>
국어 : <%=kor %><br/>
영어 : <%=eng %><br/>
수학 : <%=math %><br/>
총점 : <%=total %><br/>
평균 : <%=avg %><br/>
학점 : <%=grade %>
</body>
</html>