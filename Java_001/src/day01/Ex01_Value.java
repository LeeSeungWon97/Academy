package day01;

public class Ex01_Value {

	public static void main(String[] args) {
		
		// 변수 선언. [변수 타입] [변수명]. 메모리 할당 X
		// 변수 초기화. 메모리 할당 O
		
		// 정수 type: byte(8bit), short(16bit), int(32bit), long(32bit).
		int number;		// 변수 선언.
		
		number = 10;	// 변수 초기화
		System.out.println(number);
		
		// 변수를 선언하면서 초기화
		int number2 = 20;
		System.out.println(number2);
		
		long longVal1 = 10000L;	// 기본적으로 정수 형태는 int type으로 잡히기 때문에 L을 붙여 long type인 것을 알려줌.
		
		// 실수 type: float(32bit), double(64bit)
		double number3 = 1.00003;
		System.out.println(number3);
		
		float floatVal1 = 1.002F; // 기본적으로 정수 형태는 double type으로 잡히기 때문에 F를 붙여 float type인 것을 알려줌.
		
		// 문자 type: char, string
		
		// char: 문자 하나만 젖장 가능한 변수 type.
		char charVal1 = 'a';
		// char charVal2 = 'ab'; error: ''는 char 에서 사용. 그러나 단 하나의 문자만 저장 가능한 변수.
		// char charval3 = "B"; error: ""는 여러개의 문자를 입력할 경우 사용. String일 때 사용.
		
		// String: 문자열 변수 type.
		String stringVal1 = "ABC";	// String은 참조형 변수
		
		// 기본형 변수 vs 참조형 변수
		// 기본형: 메모리에 바로 저장
		// 참조형: 객체를 만들고 객체에 데이터를 바로 저장하는 것이 아닌 어디를 참조했는지 주소를 저장하는 형태.
		
		// boolean: true(1)과 false(0)의 값 저장 가능.
		// boolean은 조건문에 주로 사용.
		
		boolean boolVal1 = 10 > 20;	// 10 > 20 은 거짓이기 때문에 false값 저장
		boolean boolVal2 = 10 < 20;	// 10 < 20 은 거짓이기 때문에 true값 저장
		
		System.out.println(boolVal1);
		System.out.println(boolVal2);
		
		// 변수들의 연산.
		
		// 숫자(정수,실수)type의 연산. 산수 연산.
		int intVal1 = 10;
		int intVal2 = 20;
		int intVal3 = intVal1 + intVal2;		// 10 + 20 = 30이므로 int type의 30이 저장됨.
		System.out.println(intVal1 + intVal2);
		System.out.println(intVal3);
		
		// 문자type의 연산. 결합형태의 연산.
		String strVal1 = "AB";
		String strVal2 = "CD";
		String strVal3 = strVal1 + strVal2;		// AB와 CD가 결합하여 "ABCD"가 저장됨.
		System.out.println(strVal3);
		
		// 숫자 + 문자 연산: String type으로 변환.
		int num1 = 10;
		String strNum1 = num1 + "";			
		System.out.println(strNum1);		// 10이 출력되지만 int형이 아닌 String형이 출력
	}

}
