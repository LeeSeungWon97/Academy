package day04;

public class SwitchCase {

	public static void main(String[] args) {
		
		/* 
		 * switch-case 기본 형식
		 * 
		 * switch(조건변수) {		
		 * case 변수값1: 조건변수에 저장된 값이 변수값1 이면 실행되는 부분
		 * 	break;	
		 * 
		 * - 조건변수와 변수값이 같은 type이어야 함.
		 * - break: switch문을 빠져나온다.
		 * - 조건변수와 변수값이 일치하더라도 break가 없으면 break값이 나올 때까지 아랫쪽 case까지 모두 실행.
		 * 
		 * case 변수값2: 
		 * 	조건변수에 저장된 값이 변수값2 이면 실행되는 부분
		 * 	break;
		 * 
		 * default:
		 * 	위에 case가 모두 아닌 경우에 실행되는 부분
		 * 	- if문의 else와 같은 역할. 사용하지 않아도 됨.
		 * }
		 * 
		 */
		
		
		// 조건 변수 선언. int type.
		int number = 7;
		
		// switch-case문
		switch(number) {
		case 7:
			System.out.println("number는 '7' 입니다.");
			break;
		case 8:
			System.out.println("number는 '8' 입니다.");
			break;
		case 9:
			System.out.println("number는 '9' 입니다.");
			break;
		default:
			System.out.println("number는 '7', '8', '9'가 아닙니다.");
		}
		
	}

}
