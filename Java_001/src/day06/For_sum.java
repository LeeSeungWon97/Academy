package day06;

import java.util.Scanner;

public class For_sum {

	public static void main(String[] args) {

		// 1. 1 ~ 10까지의 총합

		// 총합을 저장할 변수 선언.
		int sum = 0;

		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 구분선
		System.out.print("\n");

		// 2. 조건 추가: 4의 배수 제외.

		int sum2 = 0;

		for (int i = 1; i < 11; i++) {
			if (i % 4 == 0) {	// 4의 배수 확인
				continue;
			}
			sum2 += i;
		}
		System.out.println(sum2);

		// 구분선
		System.out.print("\n");

		// 3. 범위: 1 ~ 사용자 지정. 3의 배수 합.

		Scanner scan = new Scanner(System.in);

		System.out.println("마지막 숫자: ");
		// 입력 받을 숫자를 저장할 변수 선언.
		int endNum = scan.nextInt();

		scan.close();

		int sum3 = 0;

		for (int i = 0; i < endNum; i++) {
			if (i % 3 == 0) {
				sum3 += i;
			}

		}
		System.out.println(sum3);
	}

}
