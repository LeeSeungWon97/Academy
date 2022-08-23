/*
  
  << 메소드를 통하여 필드를 변경 >>
  - 필드는 외부에서 접근할 수 없도록 막고 메소드는 공개.
  	> 필드 접근제한자: private, 메소드 접근제한자: public
  	
  - 외부에서 메소드를 통해 필드에 접근하도록 유도.
 	> 매개값을 검증하여 유효한 값만 객체의 필드로 저장할 수 있기 때문.
	
 */

package day13_1;

public class GetSet {

	private String subject; // 과목명
	private int score; // 점수

	/*
	 
	 1. Setter
	 - private로 선언된 필드의 값을 수정하고자 할 때 사용.
	 	> private 필드는 직접 접근할 수 없게 되어있기 때문.
	 - 객체는 입력 값을 setter 메소드의 매개값으로 넘겨주고 값을 검사.
	 - 그 값이 필드의 값으로 적절한 경우 저장.
	 - 데이터를 필드에 저장하기 때문에 void 타입을 주로 사용.
	 
	 2. Getter
	 - 데이터를 읽어오는 역할 수행하고자 할 때 사용.
	 - 데이터 복사본을 리턴.
	 	> 객체의 원래 데이터를 손상시키지 않음.
	 - 데이터를 내보내기 위해 return 값이 필요.
	 	> int / String 등의 return 타입을 주로 사용.
	 	
	*/
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setScore(int score) {
		if (score < 0) {
			score = 0;
		}
		
		this.score = score;
	}

	public int getScore() {
		return score;
	}


	
//	toString: 객체가 가지고 있는 모든 필드값의 정보를 문자열로 변환하여 리턴
	@Override
	public String toString() {
		return "GetSet [subject=" + subject + ", score=" + score + "]";
	}
}
