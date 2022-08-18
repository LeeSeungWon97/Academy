package day10;

public class ArrayInArray02 {

	public static void main(String[] args) {
		int[][] numbers = new int[3][3];
		numbers[0][0] = 1;
		numbers[0][1] = 2;
		numbers[0][2] = 3;

		numbers[1][0] = 4;
		numbers[1][1] = 5;
		numbers[1][2] = 6;

		numbers[2][0] = 7;
		numbers[2][1] = 8;
		numbers[2][2] = 9;

		/*
		 
		  	| 1 | 2 | 3 | 
		  	| 4 | 5 | 6 | 
		  	| 7 | 8 | 9 |
		  	
		 */

		// numbers 배열의 0행의 모든 값 출력.

		// <방법 1>
		System.out.println(numbers[0][0]);
		System.out.println(numbers[0][1]);
		System.out.println(numbers[0][2]);

		System.out.println();
		
		// <방법 2>
		for (int i = 0; i < numbers[0].length; i++) {
			System.out.println(numbers[0][i]);
		}

		
		// numbers 배열의 모든 값 출력 방법.
		
		for (int i = 0; i < numbers.length; i++) {	// numbers.length :: numbers 배열의 행의 개수
			// i = 0, 1, 2
			for (int j = 0; j < numbers[i].length; j++) {
				// j = 0, 1, 2, ...(i번째 행의 크기까지)
				System.out.print("["+numbers[i][j]+"]");
			}
			System.out.println();
		}
	}

}
