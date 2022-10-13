package day10;

import java.util.Scanner;

public class OrderList_split{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 판매 메뉴 목록
		String[] menuList = { "바닐라라떼:5000", "카페라떼:4000", "아이스티:3000", "꿀아메리카노:2500", "아메리카노:2000" };
		
		// 주문 내역 목록
		int[] orderList = new int[menuList.length];

		boolean orderCheck = false;	// 주문 유무를 확인할 변수

		int menuLength = 0;
		for (int i = 0; i < menuList.length; i++) {
			menuLength += menuList[i].split(":")[0].length() * 2 + 4;
		}

		while (true) {
			// 판매 메뉴 출력
			System.out.println("=".repeat(menuLength - 9));

			for (int i = 0; i < menuList.length; i++) {
				System.out.print("[" + (i + 1) + "]" + menuList[i].split(":")[0]+" ");
			}
			
			System.out.println("[" + (menuList.length + 1) + "]종료");

			System.out.println("=".repeat(menuLength - 9));

			// 메뉴 선택
			System.out.print("메뉴선택>>");
			int selectMenu = scan.nextInt() - 1;

			// 메뉴 선택 후 기능
			if (selectMenu >= 0 && selectMenu < menuList.length) {
				System.out.println("[" + menuList[selectMenu].split(":")[0] + " 선택]");
				System.out.println("가격은 " + menuList[selectMenu].split(":")[1] + "원 입니다.");

				System.out.println("주문하시겠습니까([1]예 [2]아니요)>>");
				int confirm = scan.nextInt();
				if (confirm == 1) {
					orderList[selectMenu] += 1;
					orderCheck = true;
					System.out.println("주문되었습니다.");
				} else {
					System.out.println("취소되었습니다.");
				}

			} else if (selectMenu == menuList.length) {
				System.out.println("[종료 선택]");
				System.out.println("주문이 종료되었습니다.");
				break;
			} else {
				System.out.println("잘못 선택하셨습니다.");
			}
			System.out.println();
		}

		if (orderCheck) {
			int totalPrice = 0; // 주문 총액을 저장할 변수
			System.out.print("\n주문하신 메뉴는 ");

			for (int i = 0; i < orderList.length; i++) {
				if (orderList[i] != 0) {
					System.out.print("[" + menuList[i].split(":")[0] + menuList[i].split(":")[1] + "잔]");
					totalPrice += orderList[i] * Integer.parseInt(menuList[i].split(":")[1]);
				}
			}
			System.out.println("이고 \n총 주문 금액은 " + totalPrice + "원 입니다.");
		}

		scan.close();
	}

}
