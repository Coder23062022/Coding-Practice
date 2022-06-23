package Heap;

public class InsertionDeletionInMaxHeap {
	public static void main(String[] args) {
		int arr[] = { 70, 50, 40, 45, 35, 39, 16, 10, 9 };
		int val = 60;
		int n = arr.length;
		arr = insertHeap(arr, n, val);
		System.out.print("After insertion: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		int newLengthAfterInsertion = arr.length;
		arr = deleteHeap(arr, newLengthAfterInsertion);
		System.out.print("\nAfter deleting all the nodes, the new sorted array is: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	static int[] insertHeap(int array[], int n, int val) {
		int arr[] = new int[n + 1];
		for (int m = 0; m < array.length; m++) {
			arr[m] = array[m];
		}
		arr[n] = val;
		int i = n + 1;
		int j = (int) Math.floor((i) / 2);

		while (arr[j - 1] < arr[i - 1]) {
			int temp = arr[j - 1];
			arr[j - 1] = arr[i - 1];
			arr[i - 1] = temp;
			i = j;
			j = (int) Math.floor(j / 2);
		}
		return arr;
	}

	static int[] deleteHeap(int array[], int n) {
		int temp = 0;
		int arr2[] = new int[n];
		while (n > 0) {
			int i = 1;
			temp = array[i - 1];
			array[i - 1] = array[n - 1];
			arr2[n - 1] = temp;
			array[n - 1] = 0;

			array = swap(array, i, n, temp);

			n = n - 1;
		}
		return arr2;
	}

	static int[] swap(int array[], int i, int n, int temp) {
		while (i < n - 1) {
			if (array[i - 1] < array[2 * i - 1] && array[2 * i - 1] > array[2 * i]) {
				temp = array[i - 1];
				array[i - 1] = array[2 * i - 1];
				array[2 * i - 1] = temp;
				i = 2 * i;
			} else if (array[i - 1] < array[2 * i]) {
				temp = array[i - 1];
				array[i - 1] = array[2 * i];
				array[2 * i] = temp;
				i = 2 * i;
			} else {
				break;
			}
		}
		return array;
	}
}