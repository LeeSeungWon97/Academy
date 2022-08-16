package day08;

import java.util.Scanner;

public class Ex04_ArrayScore {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] subject = { "JAVA", "HTML", "JAVASCRIPT", "ORACLE" };
		int subLength = subject.length;

//		과목의 점수를 저장할 배열 선언
		int[] scores = new int[subLength];

		for (int i = 0; i < subLength; i++) {
			System.out.print(subject[i] + "과목의 점수>>");
			scores[i] = scan.nextInt();

		}

		System.out.println("\n");

//		subject, scores 배열 활용. 학점 판별.
//		90이상 A, 80이상 B, 70이상 C, 70미만 재수강

		String[] grade = new String[subLength];

		for (int i = 0; i < subLength; i++) {
			if (scores[i] >= 90) {
				grade[i] = "A학점";
			} else if (scores[i] >= 80) {
				grade[i] = "B학점";
			} else if (scores[i] >= 70) {
				grade[i] = "C학점";
			} else {
				grade[i] = "재수강";
			}
			System.out.println(subject[i] + "과목: " + grade[i]);
		}

		// 구분선

		System.out.println("\n");

//		과목명으로 점수 검색.

		
		// 과목명 저장 변수 선언
		System.out.print("과목명을 입력하세요>>");
		String subName = scan.next();

		scan.close();

		// 과목명 일치 여부 확인을 위한 인덱스 변수 선언
		int idx = -1;

		// 검색
		for (int i = 0; i < subLength; i++) {
			if (subName.equals(subject[i])) {
				idx = i;
			}
		}

		if (idx >= 0) { // 과목명 일치 항목 O
			System.out.println(subject[idx] + "과목 점수는 " + scores[idx] + "점, " + grade[idx] + "입니다.");
		} else { // 과목명 일치 항목 X
			System.out.println("과목명을 찾을 수 없습니다.");
		}

	}

}
