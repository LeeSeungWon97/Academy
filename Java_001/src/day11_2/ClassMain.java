package day11_2;

public class ClassMain {

	public static void main(String[] args) {
		// int 타입의 number변수 선언
		int number = 10;
		System.out.println("number : " + number);

		System.out.println();
		
		//	Class 클래스 타입의 ex01 객체를 생성
		Class ex01 = new Class();
		System.out.println("ex01.num: " + ex01.num);

		ex01.num = 1000;
		System.out.println("ex01.num: " + ex01.num);

		ex01.str1 = "ABC";
		System.out.println("ex01.str1: " + ex01.str1);
		System.out.println("ex01.day : " + ex01.day);

		System.out.println();
		
		//	Class 클래스 타입의 ex02객체 생성
		Class ex02 = new Class();
		System.out.println("ex02.num : " + ex02.num);
		System.out.println("ex02.str2 : " + ex02.str1);
		System.out.println("ex02.day : " + ex02.day);

		// 저장하면서 선언한 필드는 초기값이 같지만 이후 다른 값으로 바꿀 수 있음.
		ex02.day = "토요일";	
		System.out.println("ex02.day : " + ex02.day);
		
		System.out.println("\n");
		/*************************************************/
		
		// 기본생성자로 Object 선언.
		Class exObj = new Class();
		System.out.println("exObj.str1: " + exObj.str1);
		
		// 매개변수가 1개 있는 생성자로 Object선언.
		Class exObj2 = new Class("승원");
		System.out.println("exObj2.str1: " + exObj2.str1);
	}

}
