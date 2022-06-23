package Array;

import java.util.HashSet;

public class DuplicateInArray {
	public static void main(String[] args) {
		// Time complexity is O(n) and Space complexity is O(1)
		int[] a = { 2, 5, 1, 7, 9, 5, 2, 7 };
		HashSet<Integer> hs = new HashSet<>();
		System.out.println("Duplicate numbers are:");
		for (int i = 0; i < a.length; i++) {
			if (hs.contains(a[i])) {
				System.out.println(a[i]);
			} else {
				hs.add(a[i]);
			}
		}
	}
}