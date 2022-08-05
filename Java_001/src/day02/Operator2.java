package day02;

public class Operator2 {

	public static void main(String[] args) {
		
		//	비교 연산자( <, >, <=, >=, ==, != )
		//	결과 값은 boolean type으로 받음. true(1) 또는 false(0).
		//	조건을 줄 때 자주 사용.
		
		int number1 = 8;
		int number2 = 5;
		boolean result;
		
		//	< 연산자: 작다.
		result = number1 < number2;
		System.out.println(number1 + " < " + number2 + " = " + result);
		
		//	> 연산자: 크다.
		result = number1 > number2;
		System.out.println(number1 + " > " + number2 + " = " + result);
		
		// 	<= 연산자: 작거나 같다.
		result = number1 <= number2;
		System.out.println(number1 + " <= " + number2 + " = " + result);
		
		//	>= 연산자: 크거나 같다.
		result = number1 >= number2;
		System.out.println(number1 + " >= " + number2 + " = " + result);

		//	== 연산자: 같다.
		result = number1 == number2;
		System.out.println(number1 + " == " + number2 + " = " + result);

		//	!= 연산자: 크거자 같다.
		result = number1 != number2;
		System.out.println(number1 + " != " + number2 + " = " + result);

		
		//	구분선
		System.out.println("-----------------------------------------");
		
		//	AND 연산자(&&): 조건이 모두 true일 경우에만 true.
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println((10 > 5) && (20 > 10));	//	true && true == true
		System.out.println((10 > 5) && (20 < 10));	//	true && false == false
		
		//	구분선
		System.out.println("-----------------------------------------");
		
		//	OR 연산자(||): 조건이 하나라도 true인 경우 true.
		System.out.println(false || true);
		System.out.println(false || false);
		System.out.println((10 < 5) || (20 > 10));	//	false || true == true
		System.out.println((10 < 5) || (20 < 10));	//	false || false == false
		
		//	3개의 변수 비교
		number1 = 50;
		number2 = 100;
		int number3 = 30;
		
		boolean resultAnd = (number1 < number2) && (number1 < number3);		//	true && false == false
		System.out.println("resultAnd : " + resultAnd);
		
		boolean resultOr = (number1 < number2) || (number1 < number3);		// true || false == true
		System.out.println("resultOr : " + resultOr);
		
	}

}
