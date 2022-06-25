package src.Practice;

public class Test1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int n = 4;
//		int arr[] = { 2, 3, 5, 10 }; int n = 15;
		int m = arr.length;
		System.out.println(countWays(arr, m, n));
	}

	static long countWays(int coins[], int m, int n) {
		int a[][] = new int[m][n + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					if ((j + 1) % coins[i] == 0)
						a[i][j] = 1;
					else
						a[i][j] = 0;
				} else {
					if (coins[i] > j + 1)
						a[i][j] = a[i - 1][j];
					else if (coins[i] == j + 1)
						a[i][j] = 1 + a[i - 1][j];
					else if (coins[i] < j + 1)
						a[i][j] = a[i - 1][j] + a[i][j - coins[i]];
				}
			}
		}
		return a[m - 1][n - 1];
	}
}