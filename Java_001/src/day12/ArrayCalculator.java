package day12;

public class ArrayCalculator {

	public int arraySum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public int arrayAvg(int[] arr) {

		// 같은 Class의 다른 메소드를 호출.
		int sum = arraySum(arr);
		int avg = sum / arr.length;
		return avg;
	}

}
