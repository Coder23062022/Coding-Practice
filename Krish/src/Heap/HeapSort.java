package src.Heap;

//Time complexity of this problem is O(nlogn).
//To build the heap by heapify method, it will take O(n). Height of the tree is logn. So complexity will be O(nlogn).

public class HeapSort {
	public static void main(String[] args) {
		int arr[] = { 30, 17, 20, 1, 5, 10, 15 };
		int n = arr.length;
		// Build the heap.
		// Call the heapify method from the non-leaf node which has the largest index
		// which can be found by the formula (n/2 - 1). So the loop will start from (n/2
		// -1)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		// Delete from the heap - One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			// call max heapify on the reduced heap. Passing '0' here because heapify will
			// be called here from root node node only as deletion will be happened from the
			// root node.
			heapify(arr, i, 0);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}
}