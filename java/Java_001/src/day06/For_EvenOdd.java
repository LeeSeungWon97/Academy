package day06;

import java.util.Scanner;

public class For_EvenOdd {

	public static void main(String[] args) {
		// 선택한 숫자 사이의 홀수, 짝수, 4의 배수의 개수 출력

		Scanner scan = new Scanner(System.in);

		// Step 1. 시작 숫자와 마지막 숫자 입력 받기.

		// 시작 숫자 입력 받기
		System.out.print("시작 숫자: ");
		int startNum = scan.nextInt();

		// 마지막 숫자 입력 받기
		System.out.print("마지막 숫자: ");
		int endNum = scan.nextInt();

		scan.close();

		// Step 2. 홀수, 짝수, 4의 배수의 개수를 저장할 변수 선언.
		int evenCount = 0;
		int oddCount = 0;
		int fourCount = 0;

		// Step3. for문을 이용하여 조건에 맞는 개수 카운트.
		for (int i = startNum; i <= endNum; i++) {
			if (i % 2 == 0) { // 짝수이면
				if (i % 4 == 0) { // 4의 배수이면 (4의 배수는 짝수에 포함됨)
					fourCount++;
				}
				evenCount++;
			} else { // 짝수가 아니면 (홀수)
				oddCount++;
			}
		}

		System.out.println("홀수는 " + evenCount + "개 입니다.");
		System.out.println("짝수는 " + oddCount + "개 입니다.");
		System.out.println("4의 배수는 " + fourCount + "개 입니다.");

	}

}
