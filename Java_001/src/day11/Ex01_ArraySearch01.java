package day11;

import java.util.Scanner;

public class Ex01_ArraySearch01 {

	public static void main(String[] args) {
		
		// 배열 선언
		int[][] numbers = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9, 10 } };

		
		// 배열 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(i + "행 : ");
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print("[" + numbers[i][j] + "]");
			}
			System.out.println();
		}
		
		// 검색할 숫자 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 숫자 입력>>");
		int searchNumber = scan.nextInt();
		
		
		
		/*
		 	검색할 숫자 입력 >> 5 정수 5는 1행 1열에 있습니다.
		 */

		
		// 검색한 숫자의 위치를 저장할 변수 선언.
		int row = -1;
		int col = -1;
		
		// 원하는 숫자가 배열에 있는지 확인
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				// 일치하는 값을 찾았으면 배열의 위치(행,열) 값을 저장
				if (numbers[i][j] == searchNumber) {
					row = i;
					col = j;
					System.out.println("정수 " + searchNumber + "는 " + row + "행 " + col + "열에 있습니다.");
				}
			}
		}
		
		// 같은 숫자를 찾았을 경우 바꿀 숫자 입력
		if(row > -1) {
			System.out.print("수정할 숫자 입력>>");
			int modNum = scan.nextInt();
			numbers[row][col] = modNum;
			
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(i + "행 : ");
				for (int j = 0; j < numbers[i].length; j++) {
					System.out.print("[" + numbers[i][j] + "]");
				}
				System.out.println();
			}
		}
		// 값은 숫자를 찾지 못했을 경우
		else {
			System.out.println("숫자를 찾을 수 없습니다.");
		}
		
		
		scan.close();
	}

}
