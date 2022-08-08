/***** Ex02_elseif *****/


/*
 * 현재 갖고 있는 돈 : 사용자로부터 입력받아서 사용
 * 현재 돈이 5000원 이상이면 "바닐라 라떼를 마신다." 출력
 * 	이때 바닐라 라떼의 가격은 4000원
 * 현재 돈이 5000원 미만 4000원 이상이면 "아이스 티를 마신다." 출력
 * 	이때 아이스티의 가격은 3500원
 * 현재 돈이 4000원 미만 3000원 이상이면 "아메리카노를 마신다." 출력
 * 	이때 아메리카노의 가격은 3000원.
 * 
 * 현재 잔액을 출력
 */

package day03;

import java.util.Scanner;

public class Ex02_elseif {

	public static void main(String[] args) {
		// 현재 잔액을 입력.
		Scanner scan = new Scanner(System.in);
		
		System.out.println("현재 갖고 있는 돈 >>");
		
		// 현재 잔액을 저장하는 변수 선언.
		int currentMoney = scan.nextInt();
		scan.close();
		
		// 구매한 음료의 이름과 가격을 저장하는 변수 선언.
		String menuName = "";
		int drink = 0;
		
		
		// if문 실행.
		
		if(currentMoney >= 5000) {
			menuName = "바닐라 라떼";
			drink = 4000;
		} else if(currentMoney >= 4000) {
			menuName = "아이스 티";
			drink = 3500;
		} else if(currentMoney >= 3000) {
			menuName = "아메리카노";
			drink = 3000;
		}
		
		// 음료를 산 후 잔액 계산.
		currentMoney -= drink;
		
		// 결과 출력
		System.out.println(menuName + "를 마신다.");
		System.out.println("현재 잔액은 " + currentMoney + "입니다.");
		
		
	}

}
