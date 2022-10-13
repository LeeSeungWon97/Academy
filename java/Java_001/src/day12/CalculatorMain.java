package day12;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Scanner scan = new Scanner(System.in);
		
		// 계산기 전원 
		calc.powerOn();
		
		int num1 = calc.inputNumber();
		int num2 = calc.inputNumber();

		// 덧셈, 뺼셈, 곱셈, 나눗셈 선택
		calc.showMenu();
		int selectMenu = scan.nextInt();
		int result = 0;
				
				
		switch(selectMenu) {
		case 1:
			System.out.println("덧셈 결과: ");
			result = calc.plus(num1, num2);
			break;
		case 2:
			System.out.println("뺄셈 결과: ");
			result = calc.minus(num1, num2);
			break;
		case 3:
			System.out.println("곱셈 결과: ");
			result = calc.multi(num1, num2);
			break;
		case 4:
			System.out.println("나눗셈 결과: ");
			result = calc.div(num1, num2);
			break;
		}
		System.out.println(result);
		scan.close();
	}

}
