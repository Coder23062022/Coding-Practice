package Krish.src.DSAlgo.Array;

import java.util.Arrays;

public class SmallestAndLargestInAStringArray {
	static void main() {
		String str = "welcometojava";
		int k = 3;
		System.out.println(getSmallestAndLargest(str, k));
	}

	static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		String[] arr = new String[s.length() - 2];

		for (int i = 0; i + 3 <= s.length(); i++) {
			arr[i] = s.substring(i, i + 3);
		}
		Arrays.sort(arr);
		smallest = arr[0];
		largest = arr[arr.length - 1];
		return smallest + "\n" + largest;
	}
}