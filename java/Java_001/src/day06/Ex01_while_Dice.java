/*
 1. 사용자로부터 목표 값을 입력 받기
 2. 주사위를 던졌을 때 주사위의 눈과 목표 값이 일치하는지 확인
 3. 일치하지 않으면 주사위를 다시 던지기
 4. 목표 값과 주사위의 눈이 일치할 때까지 주사위를 던진 횟수 출력
 */

package day06;

import java.util.Scanner;

public class Ex01_while_Dice {

	public static void main(String[] args) {
//		Step1. 목표 값 입력받기.
		Scanner scan = new Scanner(System.in);
		System.out.print("목표 값(1 ~ 6): ");
		int goalNum = scan.nextInt();

		scan.close();

//		Step2. 변수 선언.
		int diceCount = 0;
		
//		Step3. 반복문을 통해 목표 값과 주사위 눈이 같을 때 까지 반복

		while (true) {
			// 주사위 랜덤 값 설정(1 ~ 6).
			int diceNum = (int) (Math.random() * 6) + 1;
			diceCount++;
			System.out.println("주사위: " + diceNum);
			
			// 목표 값과 주사위 눈이 같을 경우
			if(goalNum == diceNum) {
				System.out.println("일치");
				break;
			}
		}
		
//		Step4. 결과 출력
		System.out.println("던진 횟수: " + diceCount);

	}

}
