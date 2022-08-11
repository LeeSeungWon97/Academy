/***** 특정 문자/숫자 입력시 while문 중지시키기 *****/

package day06;

import java.util.Scanner;

public class While_03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

//		while (true) {
//			System.out.print("숫자입력(0: 종료)>>");
//			int inputNum = scan.nextInt();
//
//			if (inputNum == 0) {
//				System.out.println("종료");
//				break;
//			}
//
//			System.out.println("입력한 숫자: " + inputNum);
//		}

		/* 랜덤 숫자 맞추기 */

		// Math.random(): double type 랜덤 숫자 발생(0.0 ~ 0.9)
		int randomNumber = (int) (Math.random() * 10) + 1; // 1~10까지 랜덤 숫자
		int count = 0; // 맞추는데 걸린 횟수

		while (true) {
			System.out.print("숫자입력>>");
			int inputNumber = scan.nextInt();
			count++;

			if (randomNumber == inputNumber) {
				System.out.println("같은 숫자 입력");
				System.out.println("종료");
				break;
			} else {
				System.out.println("다른 숫자를 입력했습니다.");
			}
		}
		scan.close();
		System.out.println(count + "번의 시도를 했습니다.");
	}

}
