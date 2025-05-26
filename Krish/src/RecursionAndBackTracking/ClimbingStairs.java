package src.Recursion;

//Dynamic programming: Bottom-up approach. Time complexity: O(n*m), Space complexity: O(n)
public class ClimbingStairs {
	// Recursive function to find total ways to reach the n'th stair from the bottom
	// when a person is allowed to take at most `m` steps at a time.
	public static int totalWays(int n, int m) {
		// create an array of size `n+1` for storing solutions to the subproblems
		int[] lookup = new int[n + 1];

		// base case: 1 way (with no steps)
		lookup[0] = 1;

		// 1 way to reach the 1st stair
		lookup[1] = 1;

		// fill the lookup table in a bottom-up manner
		for (int i = 2; i <= n; i++) {
			lookup[i] = 0;
			for (int j = 1; j <= m && (i - j) >= 0; j++) {
				lookup[i] += lookup[i - j];
			}
		}
		return lookup[n];
	}

	public static void main(String[] args) {
		int n = 4, m = 3;
		System.out.printf("Total ways to reach the %d'th stair with at most " + "%d steps are %d", n, m,
				totalWays(n, m));
	}
}