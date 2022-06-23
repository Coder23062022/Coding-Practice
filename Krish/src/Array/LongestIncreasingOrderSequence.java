package Array;

public class LongestIncreasingOrderSequence {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 2, 4, 6, 7, 0, 1, 2 };
		System.out.println(meth(a));
	}

	static int meth(int a[]) {
		int i = 0, j = a.length - 1;
		int count1 = 0, count2 = 0;
		int max1 = 0, max2 = 0;
		while (i < j - 1) {
			if (a[i] < a[i + 1]) {
				count1++;
				i++;
			} else {
				count1++;
				max1 = count1;
				count1 = 0;
				i++;
			}

			if (max1 < count1) {
				max1 = count1;
			}

			if (a[j] > a[j - 1]) {
				count2++;
				j--;
			} else {
				count2++;
				max2 = count2;
				count2 = 0;
				j--;
			}

			if (max2 < count2) {
				max2 = count2;
			}
		}
		return Math.max(max1, max2);
	}
}