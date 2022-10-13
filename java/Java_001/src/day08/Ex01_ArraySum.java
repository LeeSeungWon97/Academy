package day08;

import java.util.Scanner;

public class Ex01_ArraySum {

	public static void main(String[] args) {

		// int타입의 크기가 5인 배열 선언.

		int[] scores = new int[5];

		scores[0] = 83;
		scores[1] = 74;
		scores[2] = 97;
		scores[3] = 85;
		scores[4] = 100;

		int sum = 0;

		// scores 배열의 모든 값 출력
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] :" + scores[i]);
			sum += scores[i];
		}

		System.out.println("총합은 " + sum + "점 입니다.");

		double average = ((double) sum / scores.length);
		System.out.println("평균은 " + average + "점 입니다.");

		// 구분선
		System.out.println("\n");

		/***** 점수를 직접 입력하는 방법 *****/
		Scanner scan = new Scanner(System.in);

		scores = new int[4];
		sum = 0;

		for (int i = 0; i < scores.length; i++) {
			System.out.print((i + 1) + "번째 점수를 입력>>");
			scores[i] = scan.nextInt();
			sum += scores[i];
		}

		System.out.println("점수 입력 종료");
		scan.close();

		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] :" + scores[i]);
		}
		
		System.out.println("총합은 " + sum + "점 입니다.");

		average = ((double) sum / scores.length);
		System.out.println("평균은 " + average + "점 입니다.");
		
	}

}
