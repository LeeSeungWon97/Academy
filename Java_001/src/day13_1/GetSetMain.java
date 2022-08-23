package day13_1;

public class GetSetMain {

	public static void main(String[] args) {

		String subject1 = "JAVA";
		int score1 = 80;
//		int score1 = -80;
		GetSet sub1 = new GetSet();

		// sub1객체에 subject필드에 과목명 저장
		sub1.setSubject(subject1);
		// sub1객체에 score필드에 점수 저장
		sub1.setScore(score1);
		
		System.out.println(sub1.getSubject());
		System.out.println(sub1.getScore());
		
		System.out.println(sub1.toString()); 
	}

}
