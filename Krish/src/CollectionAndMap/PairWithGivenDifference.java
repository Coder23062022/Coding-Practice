package src.CollectionAndMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find a pair with the given difference
public class PairWithGivenDifference {
	static void findPair(Integer arr[], int diff, int listSize) {
		int i = 0, j = 1, count = 0;

		while (i < listSize && j < listSize) {
			if (Math.abs(arr[j] - arr[i]) == diff) {
				System.out.println("Pair found: " + arr[i] + "," + arr[j]);
				count++;
				i++;
				j++;
			} else if (Math.abs(arr[j] - arr[i]) < diff)
				j++;
			else
				i++;
		}
		if (count == 0) {
			System.out.println("No such pair");
		}
	}

	public static void main(String[] args) {
		int difference = 3;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(6);
		list.add(5);

		int listSize = list.size();

		Integer arr[] = new Integer[listSize];
		list.toArray(arr);
		Arrays.sort(arr);
		findPair(arr, difference, listSize);
	}
}