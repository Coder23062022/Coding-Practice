package Sorting;

public class BubbleSortOptimaztion {

	public static void main(String[] args) {
		int array[] = { 9, 5, 7, 2, 11 };
		int n = array.length;
		bubbleSortOptimization(array, n);
		/* Prints the array */
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// The space complexity for Bubble Sort is O(1), because only a single
	// additional memory space is required i.e. for temp variable.

	static void bubbleSortOptimization(int a[], int n) {
		boolean flag = true;
		for (int i = 0; i < n - 1 && flag; i++) {
			flag = false;
			// Here, j<n-1 also will work but it will unnecessary increase the number of
			// comparisons. So, j<n-1-i will reduce the internal comparisons at every pass.
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					// If swapping will happen, then only flag value will be set to true. Otherwise
					// it will be false.
					// So, in case of sorted array, the outer for loop will execute only once and it
					// will give O(n) time complexity.
					flag = true;
				}
			}
		}
	}
}