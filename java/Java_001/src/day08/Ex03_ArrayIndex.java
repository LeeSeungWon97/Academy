package day08;

import java.util.Scanner;

public class Ex03_ArrayIndex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("성적입력할 과목 수>>");
		int arr1Length = scan.nextInt();
		int[] scores = new int[arr1Length];

		for (int i = 0; i < scores.length; i++) {
			System.out.print((i + 1) + "번 째 과목의 점수>>");
			scores[i] = scan.nextInt();

		}
		scan.close();

		int maxScore = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (maxScore < scores[i]) {
				maxScore = scores[i];
			}
		}

		System.out.println("성적중 최대 값은 " + maxScore + "입니다.");
		
		// 초기값을 0이 아닌 -1로 하는 이유: 만약 찾고자 하는 값이 배열안에 없는 경우를 알기 위해.
		int idx = -1;	

		for (int i = 0; i < scores.length; i++) {
			// maxScore의 값을 scores의 값들 중 동일한 값의 index 검색
			if (maxScore == scores[i]) {	
				idx = i;
			}
		}
		if(idx >= 0) {
			System.out.println("최대값 " + maxScore + "점은 " + (idx + 1) + "번 째 과목입니다.");
		} else {
			System.out.println();
		}
	}

}
