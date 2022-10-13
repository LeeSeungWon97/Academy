package day03;

import java.util.Scanner;

public class Elseif {

	public static void main(String[] args) {
		/***** else if문 ******/
		/*
		 
		 if(조건식1) {
		 	조건식1이 true일 경우 실행되는 부분
		 }
		 else if(조건식2) {
		 	조건식1이 false이면서 조건식2가 true일 경우 실행되는 부분 
		 }
		 else if(조건식3) {
		  	조건식1 false, 조건식2 false, 조건식3 true일 경우 실행되는 부분
		 }
		 else { 
		 	조건식이 false일 경우 실행되는 부분
		 }
		 
		 */
		System.out.println("점수를 입력 해주세요>>");
		Scanner scan = new Scanner(System.in);
		
		int score =  scan.nextInt();
		scan.close();
		
		if(score >= 90) {	// score >= 90
			System.out.println("A 학점 입니다.");
		}
		else if(score >= 80) {	// 90 > score >= 80
			System.out.println("B 학점 입니다.");
		}
		else if(score >= 70) {	// 80 > score >= 70
			System.out.println("C 학점 입니다.");
		}
		else {	// 70 > score
			System.out.println("재수강 대상입니다.");
		}
		
		/**************************************************/
		System.out.println("===============================");
		
		/***** 지역변수 *****/
		// 블록 안쪽에서 선언 된 변수는 블록안에서만 사용할 수 있음. 
		
		
		int number1 = 10;	// if문 바깥에서 선언된 변수.
		
		if(10 > 5) {
			int number2 = 20;	// if문 안쪽에서 선언된 변수.
			
			// number1, number2 모두 사용 가능.
			System.out.println("if문 안쪽 출력");
			System.out.println("number1 : " + number1);
			System.out.println("number2 : " + number2);
		}
		
		// number1 사용가능. number2 사용 불가능
		System.out.println("if문 바깥 쪽 출력");
		System.out.println("number1 : " + number1);
//		System.out.println("number2 : " + number2);
		
		
		int intVal1;
		boolean result = 10 > 5;
		if(result) {
			intVal1 = 20;
			System.out.println("intVal1 : " + intVal1);
		}
//		System.out.println("intVal1 : " + intVal1);  
		// if문 바깥은 선언만 되어있고 실제로 변수의 초기화는(변수가 만들어지는 곳은) if문 안쪽이기 때문에 사용 불가능.
	}

}
