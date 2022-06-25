package src.SearchingAlgo;

//Time complexity: O(logn)

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] a = { 4, 6, 7, 8, 9, 10, 11 };
		int low = 0, high = a.length - 1;
		int n = a.length;
		int diff = (a[n - 1] - a[0]) / n; // AP series formula to find the difference
		System.out.println("The missing element is " + findMissingNumber(a, low, high, diff));
	}

	static int findMissingNumber(int[] a, int low, int high, int diff) {
		int mid = (low + high) / 2;

		// The element just after the middle element is missing
		if (a[mid + 1] - a[mid] != diff)
			return a[mid] + diff;

		// The element just before the middle element is missing
		if (mid > 0 && a[mid] - a[mid - 1] != diff)
			return a[mid - 1] + diff;

		// If the elements till mid follow AP, then recur for right half
		if (a[mid] == a[0] + mid * diff)
			return findMissingNumber(a, mid + 1, high, diff);

		// Else recur for left half
		return findMissingNumber(a, low, mid - 1, diff);
	}
}