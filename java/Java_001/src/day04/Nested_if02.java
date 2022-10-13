/***** day03/Ex02_elseif 추가 기능 *****/

/*
 *  1. 메뉴창 생성 및 선택
 *  2. 없는 메뉴를 골랐을 경우 추가
 *  3. 소지금보다 음료의 가격이 비쌀 경우 추가
 */


package day04;

import java.util.Scanner;

public class Nested_if02 {

	public static void main(String[] args) {
		// 현재 잔액을 입력.
		Scanner scan = new Scanner(System.in);

		System.out.println("현재 갖고 있는 돈 >>");

		// 현재 잔액을 저장하는 변수 선언.
		int currentMoney = scan.nextInt();

		// 구매한 음료의 이름과 가격을 저장하는 변수 선언.
		String menuName = "";
		int drink = 0;

		// 메뉴 선택 창
		System.out.println("====================================");
		System.out.println("1. 바닐라라떼 || 2. 아이스티 || 3. 아메리카노");
		System.out.println("====================================");
		System.out.println("원하는 메뉴의 번호 선택>>");

		// 메뉴 선택 변수
		int selectMenu = scan.nextInt();

		scan.close();

		// if문 실행.

		if (selectMenu == 1) {
			menuName = "바닐라라떼";
			drink = 4000;
		} else if (selectMenu == 2) {
			menuName = "아이스티";
			drink = 3500;
		} else if (selectMenu == 3) {
			menuName = "아메리카노";
			drink = 3000;
		}

		// 결과 출력

		// 없는 메뉴를 선택했는지 확인.
		// selectMenu / drink / menuName.length() 등 여러가지 변수로 적용 가능.
		// .length() : String의 글자 수 값을 반환.
		if (menuName.length() > 0) {
			// 소지금과 음료가격을 비교
			if (currentMoney >= drink) {
				// 음료를 산 후 잔액 계산.
				currentMoney -= drink;
				System.out.println(menuName + "를 마신다.");
				System.out.println("현재 잔액은 " + currentMoney + "원 입니다.");
			} else {
				System.out.println("소지금이 부족하여 구매 불가합니다.");
			}
		} else {
			System.out.println("없는 메뉴입니다. 다시 선택해 주십시오.");
		}

	}

}
