/*
 	<< ArrayList >>
 
 	- collection 프레임워크의 일부. java.util 패키지에 소속.
 	- 객체가 추가되어 용량이 초과되면 자동으로 부족한 크기만큼 용량 증가.
 	- 중간에 비어있는 index가 없어야 함. 
 	
  	1. ArrayList 선언 방법
		- ArrayList<[type]> name = new ArrayList<[type]>(size);
		
	2. ArrayList 값 추가
		- add(object) 메소드 사용.
			> ArrayList의 마지막 인덱스에 데이터 추가.
			
		- add(index, object) 사용.
			> index 번호에 데이터 값을 추가. ( 교체 X )
			> 지정한 index를 기준으로 그 이후의 데이터들의 index값이 뒤로 밀려남.
		
	3. ArrayList 크기 구하기
		- size() 메소드 사용.
	
	4. ArrayList 데이터 값 출력
		- get(index) 메소드 사용.
		
	5. ArrayList 데이터 삭제
		- remove(index) 메소드 사용.
			> 지정한 index에 저장된 데이터를 삭제
			> 삭제된 데이터의 index를 기준으로 이후 데이터들의 index가 앞으로 당겨짐.
		
		- remove(object) 메소드 사용.
			> 지정한 object의 값을 찾아 삭제
			> 삭제된 데이터의 index를 기준으로 이후 데이터들의 index가 앞으로 당겨짐. 
 
 */

package day15;

import java.util.ArrayList;

public class ArrayList01 {

	public static void main(String[] args) {

		/* Array */

		String[] strList1 = new String[2];
		strList1[0] = "A";
		strList1[1] = "B";
		// 		strList1[2] = "C";	// 처음 정해진 배열의 크기 이상의 값을 저장 불가.
		System.out.println();
		
		
		/* ArrayList */

		ArrayList<String> strList2 = new ArrayList<String>();
		System.out.println(strList2.size()); // size = 0

		strList2.add("A"); // 0번 인덱스에 "A"저장.
		System.out.println(strList2.size()); // size = 1

		strList2.add("B"); // 1번 인덱스에 "B"저장.
		System.out.println(strList2.size()); // size = 2

		
		System.out.println();
		
		// ArrayList에 저장된 각 인덱스의 데이터 값 출력
		for (int i = 0; i < strList2.size(); i++) {
			System.out.print("i = " + i);
			System.out.println(" : " + strList2.get(i));
		}
		
		
		
		System.out.println();
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		strList.add("D");
		strList.add("E");

		System.out.println("strList.size(): " + strList.size()); // size = 5

		for (int i = 0; i < strList.size(); i++) {
			System.out.println("strList.get(" + i + ") : " + strList.get(i));

		}

		System.out.println();

		strList.add(2, "목요일");

		System.out.println("strList.size(): " + strList.size()); // size = 6

		for (int i = 0; i < strList.size(); i++) {
			System.out.println("strList.get(" + i + ") : " + strList.get(i));

		}

		System.out.println();

		strList.remove(2);

		System.out.println("strList.size(): " + strList.size()); // size = 5

		for (int i = 0; i < strList.size(); i++) {
			System.out.println("strList.get(" + i + ") : " + strList.get(i));

		}
	}

}
