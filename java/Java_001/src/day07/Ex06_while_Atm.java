/* 계좌에 입금, 출금, 잔액 확인하기 */

/*

 [1] 입금: 계좌에 돈을 입금. (현재 잔액 + 입금액)
 		- 입금할 금액은 사용자에게 입력 받아서 사용
 [2] 출금: 계좌에서 돈을 출금.(현재 잔액 - 출금액)
  		- 출금할 금액은 사용자에게 입력 받아서 사용
  		- 출금할 금액이 현재 잔액보다 많은 경우
  			"잔액이 부족합니다." 출력
 [3] 잔액: 계좌의 현재 잔액을 출력
 [4] 종료: 프로그램 종료
 
 입금, 출금이 끝나면 잔액 출력
 
 */

package day07;

import java.util.Scanner;

public class Ex06_while_Atm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		// Step1. 변수 선언.
		int currentMoney = 0;	// 현재 잔액
				
		// Step2. ATM기능 실행
		
		while(run) {
			System.out.println("\n=====================================");
			System.out.println("[1]입금 || [2]출금 || [3]잔액조회 || [4]종료");
			System.out.println("=====================================");
			System.out.print("메뉴선택>>");
			
			// 1. 실행하고자 하는 업무 선택
			int selectMeun = scan.nextInt();
			
			
			switch(selectMeun){
			case 1:
				// (1) 입금
				System.out.println("[입금]");
				System.out.print("입금하실 금액을 적어주세요>>");
				int deposit = scan.nextInt();
				currentMoney += deposit;
				break;
			case 2:
				// (2) 출금
				System.out.println("[출금]");
				System.out.print("출금하실 금액을 적어주세요>>");
				int withdrawal = scan.nextInt();
				
				if(currentMoney < withdrawal) {		// 잔액 < 출금금액 일경우 
					System.out.println("잔액이 부족합니다.");
				}
				else {
					currentMoney -= withdrawal;
				}
				break;
			case 3:
				System.out.println("[잔액조회]");
				break;
			case 4:
				System.out.println("[종료]");
				run = false;
				break;
			default:
				System.out.println("없는 메뉴를 선택 했습니다.");
			}
			
 
			// Step 4. 입금, 출금, 잔액조회 선택시 잔액 출력
			if(selectMeun < 4) {
				System.out.println("\n현재 잔액: " + currentMoney);
			}
		}
		
		scan.close();

	}

}
