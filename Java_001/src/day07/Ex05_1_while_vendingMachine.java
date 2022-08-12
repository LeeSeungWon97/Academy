/***** 커피자판기 *****/
/*
 * 
 구매/취소 번호 할당
  
 구매 번호를 입력시
 - 지불금액 >= 상품금액 : "커피 한잔을 판매" 출력 후 거스름돈과 커피 재고 출력.
 - 지불금액 < 상품금액 : 지불금액이 상품금액보다 커질 때까지 추가 금액을 받음.
 
 취소 번호를 입력시
 - "취소되었습니다" 출력
 - 커피 재고량 유지
 
 커피 재고가 다 떨어지면 반복문 종료
 
 */

/*
  
 내용 추가: 구매를 눌렀다가 추가 금액을 지불하지 않고 구매를 취소하는 경우.
 추가 금액에 0을 입력하면 구매 취소
 구매 취소 문구, 커피재고, 받을 돈을 출력
  
 */

package day07;

import java.util.Scanner;

public class Ex05_1_while_vendingMachine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("커피자판기");

		// Step 1. 변수 선언

		int stock = 10; // 커피 재고
		int price = 500; // 커피 가격
		int changeMoney = 0; // 거스름돈
		int addMoney = 0;
		boolean run = true; // 커피자판기 실행 제어

		// Step 2. 재고 소진시 까지 반복문 실행
		while (run) {
			System.out.println("\n================");
			System.out.println("[1]구매 || [2]취소");
			System.out.println("================");
			System.out.print("메뉴선택>>");
			int selectMenu = scan.nextInt();

			// Step 3. 구매를 선택 했을 경우
			if (selectMenu == 1) {
				// 사용자에게 돈을 입력 받음.
				System.out.print("돈을 넣어주세요>>");
				int money = scan.nextInt();

				// 지불 금액 부족할 때
				if (money < price) {
					// 지불 금액이 충분해질 때까지 반복
					while (true) {
						System.out.println("금액이 부족합니다.");
						System.out.print("돈을 추가로 더 넣어주세요>>");
						addMoney = scan.nextInt(); // 추가로 넣은 금액
						money += addMoney;
						// 지불 금액이 충분해졌거나 구매취소를 원할 때 다음 단계 시작
						if (money >= price || addMoney == 0)
							break;
					}
					
					// Step 5. 구매 취소를 했을 때
					if(addMoney == 0) {
						System.out.println("구매를 취소하셨습니다.");
						System.out.println(money+"원을 받으세요.");
						System.out.println("남은 커피의 재고는 " + stock + "잔 입니다.");
						continue;
					}
				}
				
				System.out.println("커피 한잔을 판매");
				stock--; // 커피 재고 감소
				changeMoney = money - price; // 거스름돈 계산
				if (changeMoney > 0) {
					System.out.println("거스름돈 " + changeMoney + "원을 받으세요.");
				}
				
			}

			// Step 4. 취소를 선택했을 경우
			else {
				System.out.println("취소되었습니다.");
			}
			System.out.println("남은 커피의 재고는 " + stock + "잔 입니다.");

			// Step 5. 재고가 다 떨어졌을 경우
			if (stock <= 0) {
				System.out.println("커피의 재고가 모두 소진되었습니다.");
				run = false;
			}
		}
		scan.close();
	}

}
