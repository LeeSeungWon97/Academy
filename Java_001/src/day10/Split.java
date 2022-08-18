/***** split *****/
// 기준을 설정을 하여 문자열을 기준문자를 기점으로 앞뒤로 분리해줌.

package day10;

public class Split {

	public static void main(String[] args) {

		String menu1 = "바닐라라떼:5000";
		System.out.println(menu1);
		String[] menu1_split = menu1.split(":"); // 기준문자 (:) - "바닐라라떼:5000" >> "바닐라라떼", "5000"
													// index [0] [1]
		System.out.println("menu1_split.lenght: " + menu1_split.length);

		String menu2 = "카페라떼:4000";
		System.out.println("메뉴는 " + menu2.split(":")[0]);
		System.out.println("가격은 " + menu2.split(":")[1]);

		String[] menuList = { "바닐라라떼:5000", "카페라떼:4000", "아이스티:3000", "꿀아메리카노:2500", "아메리카노:2000" };

		// menuList의 0번 index의 문자열을 메뉴, 가격으로 분리

		// 방법 1
		String menuList1 = menuList[0];
		String[] menuList1_split = menuList1.split(":");
		System.out.println("메뉴는 " + menuList1_split[0]);
		System.out.println("가격은 " + menuList1_split[1]);

		// 방법 2
		System.out.println("메뉴는 " + menuList[1].split(":")[0]);
		System.out.println("가격은 " + menuList[1].split(":")[1]);

		System.out.println("메뉴선택>>");
		int selectMenu = 4;
		String menuName = menuList[selectMenu].split(":")[0];
		String menuPrice = menuList[selectMenu].split(":")[1];

		// String type을 int type으로 변환. 단 숫자형식이 아니면 불가
		int menuPrice_int = Integer.parseInt(menuPrice);

		System.out.println();

		System.out.println("[" + menuName + "선택]");
		System.out.println("[" + menuPrice + "원 입니다.]");
		System.out.println(menuPrice_int + 5000);

	}

}
