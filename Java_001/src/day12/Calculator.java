package day12;

import java.util.Scanner;

public class Calculator {

	int result;
	
	Scanner scan = new Scanner(System.in);
	
	public Calculator() {
		System.out.println("Calculator() 생성자 호출");
	}

	public int inputNumber() {
		System.out.println("숫자입력>>");
		return scan.nextInt();
	}
	
	
	public void showMenu() {
		System.out.println("[1]덧셈 [2]뺄셈 [3]곱셈 [4]나눗셈");
		System.out.println("메뉴선택>>");
	}
	
	public void powerOn() {
		System.out.println("계산기 전원이 켜졌습니다.");
	}

	public int plus(int number1, int number2) {
		System.out.println("덧셈기능 호출");
		return number1 + number2;
	}

	public int minus(int number1, int number2) {
		System.out.println("뺄셈기능 호출"); 
		return number1 - number2;
	}
	
	public int multi(int number1, int number2) {
		System.out.println("곱셈기능 호출"); 
		return number1 * number2;
	}
	
	public int div(int number1, int number2) {
		System.out.println("나눗셈기능 호출"); 
		return number1 / number2;
	}
	
}
