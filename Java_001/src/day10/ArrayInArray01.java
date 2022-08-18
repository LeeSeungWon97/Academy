/***** 이중배열 *****/

package day10;

public class ArrayInArray01 {

	public static void main(String[] args) {
		int[] numbers = new int[3];
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;

//					 	 [0]  [1]  [2]
//		numbers[]	::	| 10 | 20 | 30 |

//		2차원 배열		
		int[][] numbers2 = new int[2][3]; // 2줄 3칸
		
		

//							    [0]		  [1]	    [2]
//		numbers2[][]	::	|    50   |         |         | row(행) 0행
//							|         |         |    80   | 		1행
//							 column(열)
//							    0열	       1열		 2열

		numbers2[0][0] = 50;
		numbers2[1][2] = 80;
		
		System.out.println(numbers2[0][0]);
		System.out.println(numbers2[0][1]);
		System.out.println(numbers2[0][2]);
		System.out.println(numbers2[1][0]);
		System.out.println(numbers2[1][1]);
		System.out.println(numbers2[1][2]);
		
		// 이중배열의 행의 개수
		System.out.println("numbers2[] 배열의 행의 개수: " + numbers2.length);
		System.out.println("numbers2[0] 행의 크기: " + numbers2[0].length);
		System.out.println("numbers2[1] 행의 크기: " + numbers2[1].length);
		
	}

}
