package src.Array;

//Example:
//Input: {2,2,3,3}
//Output: True

public class RearrangeArrayIntoTwoSameHalvesOfEqualSum {
	static int accumulate(int arr[], int first, int last) {
		int init = 0;
		for (int i = first; i < last; i++) {
			init = init + arr[i];
		}
		return init;
	}

	// Returns true if it is possible to divide
	// array into two halves of same sum.
	// This function mainly uses combinationUtil()
	static Boolean isPossible(int arr[], int n) {
		// If size of array is not even.
		if (n % 2 != 0)
			return false;

		// If sum of array is not even.
		int sum = accumulate(arr, 0, n);
		if (sum % 2 != 0)
			return false;

		// A temporary array to store all
		// combination one by one int k=n/2;
		int half[] = new int[n / 2];

		// Print all combination using temporary
		// array 'half[]'
		return combinationUtil(arr, half, 0, n - 1, 0, n, sum);
	}

	/*
	 * arr[] ---> Input Array half[] ---> Temporary array to store current
	 * combination of size n/2 start & end ---> Staring and Ending indexes in arr[]
	 * index ---> Current index in half[]
	 */
	static Boolean combinationUtil(int arr[], int half[], int start, int end, int index, int n, int sum) {
		// Current combination is ready to
		// be printed, print it
		if (index == n / 2) {
			int curr_sum = accumulate(half, 0, n / 2);
			return (curr_sum + curr_sum == sum);
		}

		// replace index with all possible elements.
		// The condition "end-i+1 >= n/2-index" makes
		// sure that including one element at index
		// will make a combination with remaining
		// elements at remaining positions
		for (int i = start; i <= end && end - i + 1 >= n / 2 - index; i++) {
			half[index] = arr[i];
			if (combinationUtil(arr, half, i + 1, end, index + 1, n, sum))
				return true;
		}
		return false;
	}

	public static void main(String[] s) {
		int arr[] = { 1, 2, 4, 4, 5, 6 };

		if (isPossible(arr, arr.length))
			System.out.println("Yes");
		else
			System.out.println("NO");
	}
}