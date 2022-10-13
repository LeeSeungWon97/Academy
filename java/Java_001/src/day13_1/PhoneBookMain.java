package day13_1;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 전화번호부 객체 배열 선언
		// 해당하는 Class 타입의 정보만 저장가능
		PhoneBook[] pbList = new PhoneBook[5];

		// 한 사람(1번)의 전화번호 정보를 저장할 객체 선언.
		PhoneBook phoneBook1 = new PhoneBook();

		System.out.print("이름입력>>");
		String name1 = scan.next();

		System.out.print("전화번호입력>>");
		String tel1 = scan.next();

		phoneBook1.setName(name1);
		phoneBook1.setTel(tel1);
		phoneBook1.setNumber(1);

		pbList[0] = phoneBook1;

		// 2번 전화번호 정보
		PhoneBook phoneBook2 = new PhoneBook();

		System.out.print("이름입력>>");
		// String name2 = scan.next();
		phoneBook2.setName(scan.next());

		System.out.print("전화번호입력>>");
		// String tel2 = scan.next();
		phoneBook2.setTel(scan.next());

		phoneBook2.setNumber(2);

		pbList[1] = phoneBook2;

		// 모든 전화번호부 내용을 출력
		for (int i = 0; i < pbList.length; i++) {
			if (pbList[i] != null) {
				// System.out.println("pbList[" + i + "]: " + pbList[i].getName());
				System.out.println(pbList[i].toString());
			}
		}
		
		scan.close();
	}

}
