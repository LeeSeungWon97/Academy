package day04;

import java.util.Scanner;

public class Ex01_switchcase {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 메뉴 선택 창
		System.out.println("====================================");
		System.out.println("1. 바닐라라떼 || 2. 아이스티 || 3. 아메리카노");
		System.out.println("====================================");
		System.out.println("원하는 메뉴의 번호 선택>>");
		
		// 메뉴 선택 변수
		int selectMenu = scan.nextInt();

		// if문 실행.
		
		switch(selectMenu) {
		case 1:
			System.out.println("바닐라라떼를 선택했습니다.");
			break;
		case 2:
			System.out.println("아이스티를 선택했습니다.");
			break;
		case 3:
			System.out.println("아메리카노를 선택했습니다.");
			break;
		default:
			System.out.println("없는 메뉴입니다.");
		}
		
		System.out.println("과목입력>>");
		
		// 조건 변수 선언. String type.
		// scan.next(): 문자 입력받음.
		String subject = scan.next();
		scan.close();

		switch(subject) {
		case "JAVA":
			System.out.println("JAVA 입니다.");
			break;
		case "HTML":
			System.out.println("HTML 입니다.");
			break;
		default:
			System.out.println("없는 과목입니다.");
		}
		
		System.out.println("IF문");
		
		/***** == vs equals *****/
		/*
		 * <공통점>
		 * 양쪽의 내용을 비교 후 boolean값을 반환.
		 * 
		 * <차이점>
		 * .equals(): 메소드. 객체끼리 내용 자체를 비교할 수 있음.
		 * ==: 연산자. 비교하기 원하는 대상의 주소 값을 비교.
		 * 
		 */
		
		
		// ==를 사용하여 비교. 조건문이 false가 반환이 되어 실행이 되지 않음.
		if(subject == "JAVA") {
			System.out.println("JAVA입니다.");
		}
		
		// .equals()를 이용하여 비교. 조건문이 true가 반환되어 실행.		
		if(subject.equals("JAVA")) {
			System.out.println("JAVA입니다.");
		}
		
	}

}
