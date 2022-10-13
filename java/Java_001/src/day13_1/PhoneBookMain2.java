package day13_1;

import java.util.Scanner;

public class PhoneBookMain2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 전화번호부
		PhoneBook[] pbList = new PhoneBook[10];

		// 전화번호부에 저장된 번호의 개수
		int pbCount = 0;

		boolean run = true;

		while (run) {
			System.out.println("\n====================================");
			System.out.println(" [1]저장 | [2]출력 | [3]검색 | [4]종료");
			System.out.println("====================================");
			System.out.print("메뉴선택>>");

			int selectMenu = scan.nextInt();
			switch (selectMenu) {

			// 전화번호부에 새 번호 저장.
			case 1:
				System.out.println("[1]저장");
				System.out.print("저장할 이름입력>>");
				String inputName = scan.next();
				System.out.print("저장할 전화번호입력>>");
				String inputTel = scan.next();

				PhoneBook phoneBook = new PhoneBook(pbCount + 1, inputName, inputTel);
				pbList[pbCount] = phoneBook;
				pbCount++;

				if (pbCount == pbList.length) {
					pbCount = 0;
				}

				break;
			// 전화번호부 출력
			case 2:
				System.out.println("[2]출력");
				for (int i = 0; i < pbList.length; i++) {
					if (pbList[i] != null) {
						System.out.println(pbList[i].toString());
					}
				}
				break;
			// 전화번호부 검색
			case 3:
				System.out.println("[3]검색");

				// 이름으로 전화번호 검색
				System.out.print("이름입력>>");
				String searchName = scan.next();

				// 검색한 인덱스 값 저장
				int idx = -1;
				// 검색 결과 일치여부
				boolean check = false;

				// 검색기능
				for (int i = 0; i < pbList.length; i++) {
					if (pbList[i] != null) {
						if (pbList[i].getName().equals(searchName)) {
							check = true;
							idx = i;
						}
					}
				}

				// 일치하는 결과가 있을 경우
				if (check == true) {
					System.out.println("단축번호: " + pbList[idx].getNumber());
					System.out.println("전화번호: " + pbList[idx].getTel());

					// 연락처 수정 여부 질문
					System.out.print("연락처를 수정하시겠습니까([1]Y [2]N)>>");
					int modify = scan.nextInt();

					// 연락처 수정 선택
					if (modify == 1) {
						System.out.print("수정할 전화번호입력>>");
						pbList[idx].setTel(scan.next());
						System.out.println("전화번호가 수정되었습니다.");
					}

				}
				// 일치하는 결과가 없는 경우
				else {
					System.out.println("연락처가 없습니다.");
				}
				break;

			// 종료.
			case 4:
				run = false;
				break;
			}
		}
		System.out.println("전화번호부 종료");
		scan.close();
	}

}
