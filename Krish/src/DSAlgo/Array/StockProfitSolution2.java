package src.Array;

import java.util.HashSet;
import java.util.Set;

public class StockProfitSolution2 {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 9, 13, 11, 6, 6, 3, 3 };
		int n = arr.length;
		int target_sum = 12;

		// Set used to check the presence of element - target_sum - arr[i]
		Set<Integer> s = new HashSet<Integer>();

		// Set used to remove duplicate pair of elements
		Set<String> pair_set = new HashSet<String>();

		for (int i = 0; i < n; i++) {
			if (s.contains(target_sum - arr[i])) {
				int val1 = arr[i];
				int val2 = target_sum - arr[i];
				pair_set.add(val1 > val2 ? val1 + "," + val2 : val2 + "," + val1);
			}
			s.add(arr[i]);
		}
		System.out.print("Number of unique and distinct pairs of stocks that reached the target profit are: ");
		System.out.println(pair_set.size());
		System.out.println("The unique and distinct pairs of stocks that reached the target profit are:");
		pair_set.stream().forEach(System.out::println);
	}
}