// 판매 메뉴 : 1 바닐라라떼, 2. 카페라떼, 3. 아이스티, 4. 아메리카노, 5. 종료
// 판매 가격 : 5000, 4000, 3000, 2500

package day09;

import java.util.Scanner;

public class Ex08_OrderList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 메뉴, 가격, 주문 수량 배열
		String[] menu = { "바닐라라떼", "카페라떼", "아이스티", "아메리카노", "종료" };
		int[] price = { 5000, 4000, 3000, 2500 };
		int[] orderList = new int[menu.length];

		// 반복문 조건
		boolean run = true;

		while (run) {

			// 메뉴 선택 화면
			for (int i = 0; i < menu.length; i++) {
				System.out.print("[" + (i + 1) + "]" + menu[i] + " ");
			}

			// 메뉴 선택
			System.out.print("\n메뉴선택>>");
			int selectMenu = scan.nextInt(); // 메뉴 번호

			// 메뉴 선택 번호가 "종료"가 아닐 때
			if (selectMenu < menu.length && selectMenu > 0) {
				// 선택 메뉴의 가격과 구매 결정 확인
				System.out.println("가격은 " + price[(selectMenu - 1)] + "원 입니다.");
				System.out.println("[" + menu[(selectMenu - 1)] + " 선택]");
				System.out.println("주문하시겠습니까 ([1]예 [2]아니오)>>");
				int order = scan.nextInt();

				if (order == 1) {	// 구매 결정 시
					orderList[selectMenu - 1] += 1;	// 구매 메뉴 수량 증가
					System.out.println("주문되었습니다.\n");
				} else {
					System.out.println("주문이 취소되었습니다.\n");
				}
			}

			// "종료" 선택시
			else if (selectMenu == menu.length){

				int sum = 0;
				int totalPrice = 0;

				for (int i = 0; i < orderList.length; i++) {
					sum += orderList[i];
				}

				
				// 구매한 음료가 있는 경우
				if (sum > 0) {
					System.out.println("[주문 종료]");
					System.out.print("주문하신 메뉴는 ");
					for (int i = 0; i < orderList.length; i++) {
						if (orderList[i] != 0) {
							System.out.print("[" + menu[i] + " " + orderList[i] + " 잔] ");
							totalPrice += price[i] * orderList[i];	// 구매 음료의 총 가격
						}
					}
					System.out.println("입니다.");
					System.out.println("총 구매 금액: " + totalPrice + "원");
				} else { // 구매한 음료가 없는 경우
					System.out.println("[주문 종료]");
				}
				run = false;
				scan.close();
			} else { // 메뉴판에 없는 번호를 눌렀을 경우.
				System.out.println("잘못된 번호입니다.");
			}
		}

	}

}
