package day08;

import java.util.Scanner;

public class Ex02_ArrayMaxMin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//		키보드입력 값으로 배열의 크기 지정
		System.out.print("성적입력할 과목 수>>");
		int arr1Length = scan.nextInt();
		int[] scores = new int[arr1Length];

		for (int i = 0; i < scores.length; i++) {
			System.out.print((i + 1) + "번 째 과목의 점수>>");
			scores[i] = scan.nextInt();

		}
		scan.close();

//		scores 배열에 입력한 점수 중 최대값과 최솟값 구하기.

		int maxScore = scores[0]; // 최대값을 저장하기 위한 변수 선언.
		int minScore = scores[0]; // 최소값을 저장하기 위한 변수 선언.
		int maxIndex = 0;
		int minIndex = 0;

		for (int i = 0; i < scores.length; i++) {
			if (maxScore < scores[i]) { // 더 큰값이 나온 경우
				maxScore = scores[i]; // 최대값 교체
				maxIndex = i;
			} else if (minScore > scores[i]) { // 더 작은 값이 나온 경우
				minScore = scores[i]; // 최소값 교체
				minIndex = i;
			}
		}

		System.out.println("성적중 최대값은 " + maxScore + "점 입니다.");
		System.out.println((maxIndex + 1) + "번 째 과목 성적입니다.");
		System.out.println("성적중 최소값은 " + minScore + "점 입니다.");
		System.out.println((minIndex + 1) + "번 째 과목 성적입니다.");
	}

}
