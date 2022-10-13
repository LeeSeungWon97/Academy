package day12;

public class ArrayCalculatorMain {

	public static void main(String[] args) {
		ArrayCalculator calc = new ArrayCalculator();
		int[] scores1 = { 70, 80, 88, 77, 90 };

		// scores1 배열의 총합을 저장할 변수
		int sum1 = calc.arraySum(scores1);
		int avg1 = calc.arrayAvg(scores1);
		
		System.out.println("scores1 의 총합: " + sum1);
		System.out.println("scores1 의 평균: " + avg1);

		int[] scores2 = { 90, 80, 60 };
		int sum2 = calc.arraySum(scores2);

		System.out.println("scores2 의 총합: " + sum2);

	}
}
