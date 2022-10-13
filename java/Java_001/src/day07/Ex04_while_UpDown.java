/* 1 ~ 50 Up & Down */

/*
  
 랜덤 숫자를 하나 뽑고 사용자는 숫자를 입력.
 입력 숫자가 맞출 숫자보다 크면 Down을 출력.
 입력 숫자가 맞출 숫자보다 작으면 UP을 출력.
 입력 숫자가 1 ~ 50 사이의 숫자가 아니면 에러메시지 출력. 카운트 x
 숫자를 맞췄다면 "정답입니다"를 출력 후 시도 횟수 출력.
 
 (실행결과)
 숫자를 입력해 주세요 >> 20
 Up
 숫자를 입력해 주세요 >> 30
 Down
 숫자를 입력해 주세요 >> 100
 1 ~ 50사이의 숫자를 입력해주세요!
 숫자를 입력해 주세요 >> 23
 정답입니다!
 당신은 3번의 시도를 했습니다.
 
*/

package day07;

import java.util.Scanner;

public class Ex04_while_UpDown {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Step 1. 랜덤 숫자 발생.
		int randomNum = (int) (Math.random() * 50) + 1;
		
		// Step 2. 변수 선언.
		int tryNum = 0; // 시도 횟수

		// Step 3. 반복을 통한 숫자 맞추기.

		while (true) {
			// 1. 숫자 입력

			System.out.print("숫자를 입력해 주세요>>");
			int inputNum = scan.nextInt();

			// 2. 입력 숫자가 1~50 사이 숫자인지 판별.

			// 1 ~ 50사이 숫자 입력시
			if (inputNum >= 1 && inputNum <= 50) {

				tryNum++; // 시도횟수 증가.

				// 입력숫자 > 정답일 경우
				if (inputNum > randomNum) {
					System.out.println("Down");
				}
				// 입력숫자 < 정답일 경우
				else if (inputNum < randomNum) {
					System.out.println("Up");
				}
				// 입력숫자 = 정답일 경우
				else {
					break;
				}
			}
			
			// 1 ~ 50이 아닌 숫자를 입력시
			else {
				System.out.println("1 ~ 50사이의 숫자를 입력해주세요!");
			}
		}

		scan.close();

		// Step 4. 결과 출력
		System.out.println("정답입니다.");
		System.out.println("당신은 " + tryNum + "번의 시도를 했습니다.");
	}

}
