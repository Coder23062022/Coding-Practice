package Array;

public class DutchNationalFlagProblem {

	public static void main(String[] args) {

		// Time complexity is O(n) and Space complexity is O(1)

		int[] inputArray = { 0, 2, 1, 1, 0, 2 };
		int length = inputArray.length;
		int low = 0;
		int mid = 0;
		int high = length - 1;
		int temp = 0;

		while (mid <= high) {
			switch (inputArray[mid]) {
			case 0:
				temp = inputArray[low];
				inputArray[low] = inputArray[mid];
				inputArray[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = inputArray[mid];
				inputArray[mid] = inputArray[high];
				inputArray[high] = temp;
				high--;
				break;
			}
		}
		for (int i = 0; i < length; i++) {
			System.out.println(inputArray[i]);
		}
	}
}