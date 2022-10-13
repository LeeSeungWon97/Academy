package day10;

public class ArrayInArray04 {

	public static void main(String[] args) {
		int[][] numbers = new int[3][];
//		System.out.println(numbers[0].length);
//		오류: NullPointerException

		// numbers[i]행의 크기 선언
		numbers[0] = new int[3];
		System.out.println(numbers[0].length);
		numbers[1] = new int[2];
		System.out.println(numbers[1].length);
		numbers[2] = new int[5];
		System.out.println(numbers[2].length);

/*
 	| 1 | 2 | 3 |
 	| 4 | 5 |
 	| 6 | 7 | 8 | 9 | 10 |
 	으로 채우기
 */
		
		int[][] number1 = new int[3][];
		
		number1[0] = new int[3];
		number1[1] = new int[2];
		number1[2] = new int[5];
		
		int count = 0;
		
		for (int i = 0; i < number1.length; i++) {
			for (int j = 0; j < number1[i].length; j++) {
				count++;
				number1[i][j] = count;
				System.out.print("[" + number1[i][j] + "]");
			}
			System.out.println();
		}
	}

}
