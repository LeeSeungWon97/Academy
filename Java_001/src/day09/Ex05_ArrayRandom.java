package day09;

public class Ex05_ArrayRandom {

	public static void main(String[] args) {

		// 크기가 10인 int type 배열 선언.
		int[] numberList = new int[10]; // 숫자가 1 ~ 10까지 저장.

		
		// numberList 채우기
		for (int i = 0; i < numberList.length; i++) {
			int randomNum = (int) (Math.random() * 10 + 1);	// 랜덤숫자 발생
			boolean checkNumber = true;	// randomNumber 사용가능 유무 
			
			// 중복 여부 확인
			for(int j = 0; j < numberList.length; j++) {	
				if(randomNum == numberList[j]) {
					checkNumber = false;
				}
			}
			
			
			if(checkNumber) {	// 중복 숫자 없을 경우
				numberList[i] = randomNum;
			} else {	// 중복 숫자 있을 경우
				i--;
			}

		}		

//		numberList 배열의 모든 값 출력.
		for (int i = 0; i < numberList.length; i++) {
			System.out.print("[" + numberList[i] + "]");
		}
		
	}

}