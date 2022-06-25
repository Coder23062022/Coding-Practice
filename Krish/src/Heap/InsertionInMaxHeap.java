package src.Heap;

public class InsertionInMaxHeap {
	static void heapify(int arr[], int n, int i) {
		// Find parent
		int parent = (int) Math.floor((i - 1) / 2);

		if (parent >= 0) {
			// For Max-Heap
			// If current node is greater than its parent
			// Swap both of them and call heapify again
			// for the parent
			if (arr[i] > arr[parent]) {
				int temp = arr[i];
				arr[i] = arr[parent];
				arr[parent] = temp;

				// Recursively heapify the parent node
				heapify(arr, n, parent);
			}
		}
	}

	// Function to insert a new node to the Heap
	static int[] insertNode(int arr[], int n, int key) {
		// Increase the size of Heap by 1
		n = n + 1;

		int newArray[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}

		// Insert the element at end of Heap
		newArray[n - 1] = key;

		// Heapify the new node following a Bottom-up approach
		heapify(newArray, n, n - 1);
		return newArray;
	}

	// A utility function to print array of size n
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
	}

	// Driver Code
	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 2, 4 };
		int n = arr.length;
		int key = 15;
		arr = insertNode(arr, n, key);
		int newLength = n + 1;
		printArray(arr, newLength);
	}
}