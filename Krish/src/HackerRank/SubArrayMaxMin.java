package src.HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Question: https://www.chegg.com/homework-help/questions-and-answers/7-subarray-maxmin-given-array-subarrays-given-length-determine-minimum-element-subarray-mi-q68410206
public class SubArrayMaxMin {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(6);
		list.add(8);
		int n = list.size();
		System.out.println(maxMin(list, n, 3));
	}

	public static int maxMin(List<Integer> arrList, int n, int k) {
		List<Integer> finalList = new ArrayList<>();
		List<Integer> list = null;
		for (int i = 0; i <= n - k; i++) {
			list = new ArrayList<>();
			int j = i, temp = k;
			while (temp != 0 && j < arrList.size()) {
				list.add(arrList.get(j));
				j++;
				temp--;
			}
			Collections.sort(list);
			finalList.add(list.get(0));
		}
		Collections.sort(finalList);
		return finalList.get(finalList.size() - 1);
	}
}