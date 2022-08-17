package day09;

import java.util.Scanner;

public class Ex06_ArrayRandom2 {

	public static void main(String[] args) {
		
		
		// Step 1. 중복값 없는 numberList채우기
		int[] numberList = new int[10]; 

		for (int i = 0; i < numberList.length; i++) {
			int randomNum = (int) (Math.random() * 10 + 1);
			boolean checkNumber = true;	
			
			for(int j = 0; j < numberList.length; j++) {
				if(randomNum == numberList[j]) {
					checkNumber = false;
				}
			}
			
			if(checkNumber) {
				numberList[i] = randomNum;
			} else {
				i--;
			}

		}
		
		
		// Step 2. numberList 값 확인 후 숫자 삭제
		
		Scanner scan = new Scanner(System.in);
		
		int delCount = numberList.length;	// 삭제 가능 숫자 잔여 개수 카운트
		

		while(true) {
			
			for(int i = 0; i < numberList.length; i++) {
				System.out.print("[" + numberList[i] + "]");
			}
			
			// (1) 삭제 시킬 숫자 입력 받기
			System.out.print("\n숫자입력>>");
			int delNum = scan.nextInt();
			
			// (2) 삭제 시킬 숫자가 numberList에 있는지 확인
			for(int i = 0; i < numberList.length; i++) {
				if(delNum == numberList[i]) {	// 있을 경우
					numberList[i] = 0;
					delCount--;	// 카운트값 감소
				}
			}
			
			// Step 3. 전부 삭제 완료 시
			if(delCount == 0) {
				System.out.println("모든 숫자가 0이 되었습니다. 종료합니다.");
				scan.close();
				break;
			}
		}
	}

}
