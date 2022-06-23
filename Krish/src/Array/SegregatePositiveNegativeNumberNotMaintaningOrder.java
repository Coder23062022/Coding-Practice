package Array;

public class SegregatePositiveNegativeNumberNotMaintaningOrder {
	public static void main(String[] args) {
		int a[] = { 7, -1, -5, -2, 3, 2, -4, 1, 0 };
		int i = 0;
		int j = a.length - 1;

		while (i < j) {
			while (i < a.length && a[i] < 0)
				i++;
			while (j >= 0 && a[j] > 0)
				j--;

			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
	}
}
