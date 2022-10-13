package day03;

// Scanner를 사용하기 위해 외부 Class를 호출
import java.util.Scanner;

public class If {

	public static void main(String[] args) {
		// ctrl + shift + f : 들여쓰기 정렬.
		
		/***** 조건문 if문 ******/
		
		/*
		 
		if(조건식) { 
		조건식이 true일 경우 실행되는 부분
		}
		else {
		조건식이 false일 경우 실행되는 부분
		}
		
		*/
		
		// 조건식에서는 boolean의 값을 가질 수 있는 식이 들어가야함.
		// if는 단독으로 사용 가능. else는 단독으로 사용 불가능.
		
		
		int ifVal = 3;
		
		if(ifVal > 5) {
			System.out.println("ifVal은 5보다 큰 수입니다.");
		}
		
		else {
			System.out.println("ifVal은 5보다 작은 수 입니다.");
		}
		
		int ifVal2 = 20;
		boolean result = ifVal2 >= 10;
		
		if(result) {
			System.out.println("ifVal2은 10보다 큰 수입니다.");
		}
		
		/*************************************************/
		System.out.println("===========================");
		
		// Scanner 객체 생성 방법. System.in: 입력 값을 byte단위로 읽음
		Scanner scan = new Scanner(System.in);  
		
		System.out.println("숫자입력>>");
		int inputNumber = scan.nextInt();
		scan.close();
		
		System.out.println("입력한 숫자 : " + inputNumber);
		
		if(inputNumber > 5) {
			System.out.println(inputNumber + "은(는)" + "5보다 큰 수 입니다");
		}
		else {
			System.out.println(inputNumber + "은(는)" + "5보다 작은 수 입니다");
		}
	}
	


}