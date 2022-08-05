package day02;

public class Operator3 {

	public static void main(String[] args) {
		
		//	대입연산자 ( =, +=, -=, *=, /=, %= )
		
		//	A = B: B의 값을 A에 담는다.
		int number1 = 1;
		System.out.println("연산 전 : " + number1);
		number1 = number1 + 5;
		System.out.println("+ 연산 후 : " + number1);	//	number1 == 6
		
		//	A += B: A = A + B
		number1 += 5;
		System.out.println("+= 5 연산 후 : " + number1);	//	number1 == 11
		
		//	A -= B: A = A - B
		number1 -= 3;
		System.out.println("-= 3 연산 후 : " + number1);	//	number1 == 8
		
		//	A *= B: A = A * B
		number1 *= 2;
		System.out.println("*= 2 연산 후 : " + number1);	//	number1 == 16
		
		//	A /= B: A = A / B
		number1 /= 4;
		System.out.println("/= 4 연산 후 : " + number1);	//	number1 == 4
		
		//	A %= B: A = A % B
		number1 %= 3;
		System.out.println("%= 3 연산 후 : " + number1);	//	number1 == 1

		
		//	증감 연산자
		
		int number2 = 10;
		number2++;		//	++: += 1과 같은 역할. 변수의 값을 1 증가 시킴.
		System.out.println("number2 : " + number2);
		
		number2--;		//	--: -= 1과 같은 역할. 변수의 값을 1 감소 시킴.
		System.out.println("number2 : " + number2);
		
		//	구분선
		System.out.println("--------------------");
		
		//	증감 연산자 위치에 따른 차이
		
		//	증감 연산자 변수 뒤에 붙는 경우. 변수에 먼저 값을 담고 자신을 변화하는 형태.
		int num1 = 5;
		int result1 = num1++;	//	result1 = num1
								//	num1 = num1 + 1
		System.out.println("result1 : " + result1);
		
		
		//	증감 연산자가 변수 앞에 붙는 경우. 자신을 먼저 변화하고 변수에 값을 담는 형태.
		int num2 = 5;
		int result2 = ++num2;	//	num2 = num2 + 1
								//	result = num2
		System.out.println("result2 : " + result2);
		
		System.out.println("--------------------");
		
		//	Example
		int x = 10;
		int y = 5;
		
		int z = x++ + --y;
		//	1. y = y - 1;	y = 4
		//	2. z = x + y;	z = 14
		//	3. x = x + 1;	x = 11
		System.out.println("z = " + z);
	}

}
