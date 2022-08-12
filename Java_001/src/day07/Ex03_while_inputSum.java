/***** inputSum *****/
/*
 
 숫자를 연속적으로 입력
 0이 나오면 숫자 입력을 멈추고 그 전까지의 숫자들의 합 & 숫자 입력 횟수 출력
 
 (실행 결과)
 숫자 입력(종료: 0)>> 1
 숫자 입력(종료: 0)>> 2
 숫자 입력(종료: 0)>> 3
 숫자 입력(종료: 0)>> 0
 입력한 숫자는 3개 입니다.
 입력한 숫자들의 총합은 6입니다.
 
 */
 

package day07;

import java.util.Scanner;

public class Ex03_while_inputSum {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Step1. 변수 선언.
		int countNum = 0; // 입력 횟수 저장 변수
		int sumNum = 0; // 총합 저장 변수

		// Step2. 숫자 입력 반복
		while (true) {
			System.out.print("숫자 입력(종료: 0)>> ");
			int inputNum = scan.nextInt();

			// while문 종료 조건. 입력 숫자: 0
			if (inputNum == 0) {
				break;
			}

			// 입력 숫자가 0이 아닐 경우
			countNum++; // 입력 횟수 증가
			sumNum += inputNum; // 입력 숫자 총합
		}

		scan.close();

		// Step3. 결과 출력
		System.out.println("입력한 숫자는 " + countNum + "개 입니다.");
		System.out.println("입력한 숫자들의 총합은 " + sumNum + "입니다");

	}

}
