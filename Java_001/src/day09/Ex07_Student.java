/*
 1. 학생수 : 학생 인원수 입력
 2. 점수입력: 학생들의 점수를 입력
 3. 점수목록: 학생들의 점수를 출력
 4. 점수분석: 점수 목록의 값들 중 최대, 최소, 평균 값 출력
 5. 종료
 
 실행 순서는 1 ~ 4 차례대로 실행이 되어야 하며, 순서대로 진행되도록 안내.
 
 */

package day09;

import java.util.Scanner;

public class Ex07_Student {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		int[] score = null; // null를 이용해서 배열 초기화 선언.
		
		boolean check = false;	// 점수입력 유무 확인
		
		while (run) {
			// Step 1. 메뉴 출력
			System.out.println("===================================================");
			System.out.println("1. 학생 수 | 2. 점수입력 | 3. 점수목록 | 4. 점수분석 | 5. 종료 ");
			System.out.println("===================================================");

			// Step 2. 메뉴 숫자 입력 받기
			System.out.print("메뉴선택>>");
			int selectMenu = scan.nextInt();

			// Step 3. 해당 메뉴 실행
			switch (selectMenu) {

			// 1. 학생 수 선택
			case 1:
				System.out.println("[1. 학생 수]");
				// (1) 학생수 입력
				System.out.print("학생 수를 입력하세요>>");
				int studentNum = scan.nextInt();
				// (2) 학생수에 맞는 배열 생성.
				score = new int[studentNum];
				System.out.println("학생 수는 " + studentNum + "명 입니다.");
				check = false;
				break;

			// 2. 학생 수만큼 점수입력
			case 2:
				
				// (1) 학생 수를 입력하지 않았을 때
				if (score == null) {
					System.out.println("[1. 학생 수]를 입력해주세요.");
				} 
				
				// (2) 학생 수를 입력했을 때
				else {
					System.out.println("[2. 점수입력]");

					for (int i = 0; i < score.length; i++) {
						System.out.print((i + 1) + "번 째 학생의 점수>>");
						score[i] = scan.nextInt();
					}
				}
				check = true;
				
				break;
				
			// 3. 학생들의 점수 모두 출력
			case 3:
				// (1) 학생 수를 입력하지 않았을 때
				if (score == null) { 
					System.out.println("[1. 학생 수]를 입력해주세요.");
				} 
				// (2) 점수입력을 하지 않았을 때
				else if(!check){ 
					System.out.println("[2. 점수입력]을 입력해주세요.");
				}
				// (3) 점수입력까지 완료 했을 때
				else {
					System.out.println("[3. 점수목록]");
					for (int i = 0; i < score.length; i++) {
						System.out.println((i + 1) + "번 학생 점수: " + score[i]);
					}
				}
				break;
				
			// 4. 학생들의 점수 중 최대, 최소, 평균 값 출력
			case 4:
				
				// (1) 학생 수를 입력하지 않았을 때
				if (score == null) {
					System.out.println("[1. 학생 수]를 입력해주세요.");
				}
				// (2) 점수입력을 하지 않았을 때
				else if(!check) {
					System.out.println("[2. 점수입력]을 입력해주세요.");
				}
				
				// (3) 점수입력까지 완료했을 때
				else {
					System.out.println("[4. 점수분석]");
					
					int max = score[0];
					int min = score[0];
					int sum = 0;
					
					for(int i = 0; i < score.length; i++) {
						if(max < score[i]) {
							max = score[i];
						}
						if(min > score[i]) {
							min = score[i];
						}
						sum += score[i];
					}
					int avr = sum / score.length;
					
					System.out.println("최대값: " + max);
					System.out.println("최소값: " + min);
					System.out.println("평균값: " + avr);
				}

				break;
				
			// 프로그램 종료
			case 5:
				System.out.println("[5. 종료]");
				run = false;
				break;
			}

		}
		scan.close();
	}

}
