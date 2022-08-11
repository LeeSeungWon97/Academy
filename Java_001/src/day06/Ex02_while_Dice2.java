/*
 
 두 개의 주사위를 던져서 나오는 눈을 출력
 두 개의 주사위의 눈이 다른 값일 경우 다시 던져서 나오는 눈을 출력
 두 개의 주사위의 눈이 같은 값일 경우 종료
 주사위의 눈이 같은 값이 나올 때까지 던진 횟수 출력.
 
 (결과 예시)
 [5,6]
 [4,2]
 [3,3]
 같은 값이므로 종료.
 주사위는 3번 던졌습니다.
 
 */

package day06;

public class Ex02_while_Dice2 {

	public static void main(String[] args) {

//		Step1. 변수 선언
		int count = 0; // 주사위 던진 횟수
		
//		Step2. 반복문을 통한 조건 달성
		while (true) {
			// 1. 두 개의 주사위를 던져 나오는 숫자 확인 & 던진 횟수 카운트
			int diceNum1 = (int) (Math.random() * 6) + 1;
			int diceNum2 = (int) (Math.random() * 6) + 1;
			count++;

			// 2. 두 주사위의 숫자 출력
			System.out.println("[" + diceNum1 + "," + diceNum2 + "]");
			
			// 3. 주사위 눈이 같은지 확인.
			if(diceNum1 == diceNum2) {
				System.out.println("같은 값이므로 종료.");
				break;
			}
		}
		
//		Step3. 던진 횟수 출력
		System.out.println("주사위는 " + count + "번 던졌습니다");
	}

}
