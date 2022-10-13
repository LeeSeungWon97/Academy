package day11;

import java.util.Scanner;

public class Ex02_ArraySearch02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
		// 배열 선언
		String[][] scoreList = { { "이름", "JAVA", "HTML" }, { "학생1", "80", "90" }, { "학생2", "88", "70" },
				{ "학생3", "85", "95" } };

		
		// 과목명을 검색하여 학생들의 점수 확인
		System.out.print("검색할 과목>>");
		String searchSubject = scan.next();

		/*
		  	검색할 과목 >> HTML 
		  	학생1 : 90점 
		  	학생2 : 70점 
		  	학생3 : 95점
		 */

		
		
		int col = -1;

		for (int i = 0; i < scoreList[0].length; i++) {
			if (scoreList[0][i].equals(searchSubject)) {
				col = i;
			}
		}

		if (col > -1) {
			for (int i = 1; i < scoreList.length; i++) {
				System.out.println(scoreList[i][0] + " : " + scoreList[i][col] + "점");
			}
		} else {
			System.out.println("과목을 찾을 수 없습니다.");
		}

		
		
		// 학생이름을 입력하여 해당 학생의 점수 모두 출력.
		
		System.out.print("학생이름입력>>");
		String searchStudent = scan.next();

		int row = -1;

		for (int i = 0; i < scoreList.length; i++) {
			if (scoreList[i][0].equals(searchStudent)) {
				row = i;
			}
		}

		if (row > -1) {
			for (int i = 1; i < scoreList[row].length; i++) {
				System.out.println(scoreList[0][i] + "점수 : " + scoreList[row][i] + "점");
			}
		}

		else {
			System.out.println("학생을 찾을 수 없습니다.");
		}

		scan.close();
	}

}
