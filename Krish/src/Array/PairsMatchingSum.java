package src.Array;

import java.util.HashSet;

public class PairsMatchingSum {
	public static void main(String[] args) {
		int a[] = { 10, 20, 30, 40, 60 };
		int sum = 50;
		System.out.println(pairSum(a, sum));
		System.out.println(pairSum1(a, sum));
	}

	// In worst case, this algorithm will give O(n^2) if quick sort, otherwise
	// O(nlogn) if heap/merge sort.
	private static boolean pairSum(int a[], int sum) {
		int i = 0, j = a.length - 1;

		while (i < j) {
			if (a[i] + a[j] == sum) {
				return true;
			} else if (a[i] + a[j] < sum) {
				i++;
			} else
				j--;
		}
		return false;
	}

	// In worst case, this algorithm will give O(n) time complexity.
	private static boolean pairSum1(int a[], int sum) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			int temp = sum - a[i];
			if (hs.contains(temp)) {
				return true;
			}
			hs.add(a[i]);
		}
		return false;
	}
}