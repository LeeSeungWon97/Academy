package day08;

public class Array02 {

	public static void main(String[] args) {

		// 배열을 선언하면서 배열의 크기만 지정.
		int[] scores = new int[3];

		// scores >> [ ] | [ ] | [ ]
		// index  >>  0     1     2
		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[1]: " + scores[1]);
		System.out.println("scores[2]: " + scores[2]);
		
		scores[0] = 90;	// scores >> [90] | [ ] | [ ]
		scores[1] = 80; // scores >> [90] | [80] | [ ]
		scores[2] = 70; // scores >> [90] | [80] | [70]
		scores[0] = 85; // scores >> [85] | [80] | [70]

		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[1]: " + scores[1]);
		System.out.println("scores[2]: " + scores[2]);
		
		String[] names = new String[3];

		System.out.println("names[0]: " + names[0]);
		System.out.println("names[1]: " + names[1]);
		System.out.println("names[2]: " + names[2]);
		
		names[0] = "인천";
		names[1] = "일보";
		names[2] = "아카데미";

		System.out.println("names[0]: " + names[0]);
		System.out.println("names[1]: " + names[1]);
		System.out.println("names[2]: " + names[2]);
	
		
		
		// 기본형 배열 vs 참조형 배열
		
		int[] intArr1 = new int[2];
		System.out.println("intArr1[0]: " + intArr1[0]); // 값을 대입하지 않았을 때 : 0	
		intArr1[1] = intArr1[0] + 10;
		System.out.println("intArr1[1]: " + intArr1[1]);
		
		
		String[] strArr1 = new String[3];
		System.out.println("strArr1[0]: " + strArr1[0]); // 값을 대입하지 않았을 때 : null
		strArr1[1] = strArr1[0] + "abc";
		System.out.println("strArr1[1]: " + strArr1[1]);
		System.out.println("strArr1[2]: " + strArr1[2]);
				
		// strArr1[2]에 들어있는 null은 문자열이 아님. 데이터가 없다는 것을 의미하는 용어.
		System.out.println(strArr1[2].equals("ABCD")); // 문자열 비교 오류. NullPointerException 발생
													 
	}

}