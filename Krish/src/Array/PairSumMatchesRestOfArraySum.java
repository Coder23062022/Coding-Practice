package src.Array;

import java.util.HashSet;
import java.util.Set;

public class PairSumMatchesRestOfArraySum {
	public static void main(String[] args) {
		// Check if there exist two elements in an array whose sum is equal to the sum
		// of rest of the array
		int a[] = { 2, 11, 5, 1, 4, 7 };
		if (checkPair(a) == false) {
			System.out.println("No pair found");
		}
	}

	private static boolean checkPair(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		// If sum of array is not even than we can not
		// divide it into two part
		if (sum % 2 != 0) {
			return false;
		}

		sum = sum / 2;

		// For each element arr[i], see if there is
		// another element with value sum - arr[i]
		Set<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int val = sum - arr[i];
			if (hs.contains(val) && val == (int) hs.toArray()[hs.size() - 1]) {
				System.out.println("Pair is: " + arr[i] + ',' + val);
				return true;
			}
			hs.add(arr[i]);
		}
		return false;
	}
}