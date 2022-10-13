package day02;

public class Operator1 {
	
	public static void main(String[] args) {
		
		// 	산술 연산자(+, -, *, /, %)
		
		//	변수 선언 및 초기화
		int number1 = 10;	//	변수1
		int number2 = 3;	//	변수2
		int result = 0;		//	연산 결과 값
		
		System.out.println("number1 : " + number1);
		System.out.println("number2 : " + number2);
		
		//	+ 연산
		System.out.println("연산 전: " + result);
		result = number1 + number2;		
		System.out.println("+ 연산 후: " + result);
		
		//	- 연산
		result = number1 - number2;
		System.out.println("- 연산 후: " + result);
		
		//	* 연산
		result = number1 * number2;
		System.out.println("* 연산 후: " + result);
		
		//	/ 연산
		result = number1 / number2;
		System.out.println("/ 연산 후: " + result);
		
		//	% 연산
		result = number1 % number2;
		System.out.println("% 연산 후: " + result);
			
		//	double type 연산
		//	변수에 정수값을 넣어줘도 소수점을 표시하여 표현.
		double doubleNum1 = 10;
		double doubleNum2 = 3;
		double doubleResult = doubleNum1 + doubleNum2;
		System.out.println("doubleResult: " + doubleResult);
		
		//	type 변환
		
		int num1 = 10;
		int num2 = 3;
		double doubleResult2 = 0;
		
		//	형변환을 하지 않은 경우
		doubleResult2 = num1 / num2;		//	연산 결과가 int형이기 때문에 3의 값이 변수에 저장.
		System.out.println("(형변환 X) doubleResult: " + doubleResult2);	
		
		//	형변환을 한 경우
		doubleResult2 = (double)num1/num2;	//	연산 결과가 int형에서 double형으로 바뀌었기 때문에 3.3333... 값이 변수에 저장.
		System.out.println("(형변환 O) doubleResult: " + doubleResult2);
		
	}

}
