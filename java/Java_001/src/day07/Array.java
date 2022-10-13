/***** 배열 - array *****/
/*
 
 - 여러 개의 data를 하나에 담기위해 사용.
 - 주로 for문과 같이 사용.

 <배열 선언 방식>
 1. [배열 타입] [배열이름] = {데이터1, 데이터2, 데이터3, ...} : 선언과 동시에 인덱스에 데이터를 넣은 방법.
 	int[] arr1 = {1, 3, 2}
 	인덱스	 0	 1	 2
 	arr1	[1]	[3]	[2]
 
 2. [배열타입] [배열이름];
  	int[] arr1 = new int[3]; : 데이터는 없는 상태로 인덱스만 만드는 방법.(인덱스 3개)
   	인덱스	 0	 1	 2
   	arr1	[ ]	[ ]	[ ]
    
 <인덱스>
 - 배열안에 데이터가 저장이 되는 공간의 번호
 
   int[] arr1 = {1, 3, 2} 
   arr1 = [1][3][2]
   arr1 = [index 0] [index 1] [index 2]
   
 <출력>
 System.out.print(arr1): 주소값 출력.
 
 배열의 인덱스값을 주어야 값이 나옴.
 System.out.print(arr1[0]) -> 1 
 
 <배열의 장단점>
 - 장점: 한가지 타입의 여러 개의 데이터를 저장할 수 있음.
   
 - 단점: 중간에 사이즈를 늘릴 수가 없음.
    
 */

package day07;

public class Array {

	public static void main(String[] args) {
		
		int[] arr1 = { 1, 3, 2 };
		System.out.println("arr1: " + arr1);
		System.out.println("arr1: " + arr1[0]);
		System.out.println("arr1: " + arr1[1]);
		System.out.println("arr1: " + arr1[2]);
//		System.out.println("arr1: " + arr1[3]); 	// 인덱스 범위를 벗어났기 때문에 오류 발생.
		
		// 구분선
		System.out.println("\n");
		
		int[] arr2 = new int[3];
		System.out.println("arr2[0]: " + arr2[0]);
		arr2[0] = 100;
		System.out.println("arr2[0]: " + arr2[0]);
		
		// 구분선
		System.out.println("\n");
		
		String[] strArr1 = new String[5];
		System.out.println("strArr1[0]: " + strArr1[0]);
		strArr1[0] = "ABC";
		System.out.println("strArr1[0]: " + strArr1[0]);
		strArr1[2] = "EFG"; // 데이터 저장은 인덱스 순서와 상관없이 저장가능.
		System.out.println("strArr1[2]: " + strArr1[2]);
	}
	

}
