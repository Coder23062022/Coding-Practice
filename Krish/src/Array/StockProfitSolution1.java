package src.Array;

/*A financial analyst is responsible for a portfolio of profitable stocks represented in an array. Each item in the array represents the yearly profit of a 
 * corresponding stock. The analyst gathers all distinct pairs of stocks that reached the target profit. Distinct pairs are pairs that differ in at least one 
 * element. Given the array of profits, find the number of distinct pairs of stocks where the sum of each pair�s profits is exactly equal to the target profit.

Example:

stocksProfit = [5,7,9,13,11,6,6,3,3]

target = 12 profit's target

There are 4 pairs of stocks that have the sum of their profits equals to the target 12. Note that because there are two instances of 3 in stocksProfit there are 
tw2 pairs matching (9,3): stocksProfit indices 2 and 7, and indices 2 and 8, but only one can be included.

There are 3 distinct pairs of stocks: (5,7), (3,9), and (6,6) and the return value is 3.*/

import java.util.HashSet;
import java.util.Set;

final class Pair<T1, T2> {
	public T1 first;
	public T2 second;

	public Pair(T1 first, T2 second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair<T1, T2> other = (Pair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
}

public class StockProfitSolution1 {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 9, 13, 11, 6, 6, 3, 3 };
		int n = arr.length;
		int target_sum = 12;

		// Set used to check the presence of element - target_sum - arr[i]
		Set<Integer> s = new HashSet<Integer>();

		// Set used to remove duplicate pair of elements
		Set<Pair<Integer, Integer>> pair_set = new HashSet<Pair<Integer, Integer>>();

		for (int i = 0; i < n; i++) {
			if (s.contains(target_sum - arr[i])) {
				pair_set.add(new Pair<Integer, Integer>(arr[i], target_sum - arr[i]));
			}
			s.add(arr[i]);
		}
		System.out.print("Number of unique and distinct pairs of stocks that reached the target profit are: ");
		System.out.println(pair_set.size());
		System.out.println("The unique and distinct pairs of stocks that reached the target profit are:");
		pair_set.stream().forEach(System.out::println);
	}
}