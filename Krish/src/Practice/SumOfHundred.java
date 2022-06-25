package src.Practice;

public class SumOfHundred {

	public static void main(String[] args) {
		int set = 3, n = 4, sum = 100;

		sumHundred(n, sum, set);
	}

	static void sumHundred(int n, int sum, int set) {
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		int arr3[] = new int[n];

		for (int i = 0; i < sum; i++) {
			arr1[(int) (Math.random() * n)]++;
			arr2[(int) (Math.random() * n)]++;
			arr3[(int) (Math.random() * n)]++;
		}

		// Print array
		for (int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " " );
			System.out.print(arr2[i] + " ");
			System.out.print(arr3[i] + " ");
		}
	}
}
