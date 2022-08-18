package day10;

public class ArrayInArray03 {

	public static void main(String[] args) {

		int[][] numbers = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9 } };

		/*
		  
		 	| 1 | 2 | 3 | 
		 	| 4 | 5 | 6 | 7 | 
		 	| 8 | 9 |
		 
		 */

		int sum = 0;
		int countLength = 0;
		int count = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			countLength += numbers[i].length;
			
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print("[" + numbers[i][j] + "]");
				sum += numbers[i][j];
				count++;
			}
			System.out.println();
		}

//		numbers배열의 총합.
		System.out.println("총합: " + sum);
//		numbers배열의 모든 값의 평균
		// <방법 1>
		System.out.println("평균: " + (sum/countLength));
		// <방법 2>
		System.out.println("평균: " + (sum/count));
	}

}
