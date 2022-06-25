package src.Array;

//Problem: Find an element in array such that sum of left array is equal to sum of right array.

public class SumOfLeftArrayIsEqualToSumOfRightArray {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 1, 4, 5 };
		System.out.println("The index of the middle element is: " + findElement2(arr));
	}

	static int findElement2(int[] intArray) {
		int size = intArray.length - 1;
		int mid = (0 + size) / 2;

		while (mid < size) {
			int low = 0;
			int high = intArray.length - 1;
			int leftSum = 0;
			int rightSum = 0;

			while (low < mid) {
				leftSum = leftSum + intArray[low];
				low++;
			}

			while (mid < high) {
				rightSum = rightSum + intArray[high];
				high--;
			}

			if (leftSum == rightSum) {
				System.out.println("The middle element is: " + intArray[mid]);
				return mid;
			} else {
				mid = mid + 1;
			}
		}
		return -1;
	}
}