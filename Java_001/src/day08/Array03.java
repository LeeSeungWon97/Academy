package day08;

public class Array03 {

	public static void main(String[] args) {

		// String타입의 크기가 3인 배열 선언.
		// 1. 이름, 2. 전화번호, 3. 나이, 4. 거주지역, 5. 성별
		String[] myInfo = new String[5];
		myInfo[0] = "이승원";
		myInfo[1] = "010-7138-4656";
		myInfo[2] = "26";
		myInfo[3] = "인천";
		myInfo[4] = "남";

		System.out.println(myInfo[0]);
		System.out.println(myInfo[1]);
		System.out.println(myInfo[2]);
		System.out.println(myInfo[3]);
		System.out.println(myInfo[4]);

		// 구분선
		System.out.println("\n");

		// 배열의 크기, 길이 확인.
		System.out.println("myInfo.length : " + myInfo.length);

		// 구분선
		System.out.println("\n");
		
		for (int i = 0; i < myInfo.length; i++) {	// myInfo.length = 5.
			System.out.println(myInfo[i]);
		}
		

	}

}
