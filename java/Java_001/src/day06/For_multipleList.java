/* 입력받은 숫자 범위 안에서 n의 배수의 목록과 개수를 출력하는 방법*/

package day06;

import java.util.Scanner;

public class For_multipleList {

	public static void main(String[] args) {
		// Step 1. 숫자 입력 받기

		Scanner scan = new Scanner(System.in);

		System.out.print("시작 숫자: ");
		int startNum = scan.nextInt();

		System.out.print("마지막 숫자: ");
		int endNum = scan.nextInt();

		System.out.print("n의 배수: ");
		int multipleNum = scan.nextInt();

		scan.close();

		// Step 2. 변수 선언

		// n의 배수 목록
		String list = "";

		// n의 배수 개수
		int count = 0;

		// n의 배수의 총합
		int sum = 0;

		for (int i = startNum; i <= endNum; i++) {
			if (i % multipleNum == 0) {
				count++;
				sum += i;

				// i + n의 값이 endNum보다 작거나 같다면 n의 배수의 최대 값이 아니다.
				if (i + multipleNum <= endNum) {
					// 문자열 + 숫자 연산 >> String type 을 이용
					list += i + " ";	// 최대 값이 아닐 경우 공백을 같이 저장.
				} else {
					list += i;			// 최대 값일 경우 공백을 제외.
				}
			}
		}

		System.out.println(startNum + "부터 " + endNum + "사이의 " + multipleNum + "의 배수는 " + list + "입니다.");
		System.out.println(multipleNum + "의 배수는 총 " + count + "개 입니다.");
		System.out.println(multipleNum + "의 배수의 총 합은 " + sum + "입니다.");

	}

}
