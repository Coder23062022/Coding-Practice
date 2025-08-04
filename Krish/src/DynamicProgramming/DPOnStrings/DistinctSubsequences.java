package Krish.src.DynamicProgramming.DPOnStrings;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/distinct-subsequences/
//Video source: https://www.youtube.com/watch?v=nVG7eTiD2bY&ab_channel=takeUforward

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinctWithRecursion(s, t));
        System.out.println(numDistinctWithMemoization(s, t));
        System.out.println(numDistinctWithTabulation(s, t));
    }

    //TC: O(2^m * 2 ^n), SC: O(m + n)
    static int numDistinctWithRecursion(String s, String t) {
        int m = s.length();
        int n = t.length();
        return recursionHelper(s, t, m, n);
    }

    static int recursionHelper(String s, String t, int i, int j) {
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return recursionHelper(s, t, i - 1, j - 1) + recursionHelper(s, t, i - 1, j);
        } else {
            return recursionHelper(s, t, i - 1, j);
        }
    }

    //TC: O(m * n), SC: O(m * n) + O(m + n)
    static int numDistinctWithMemoization(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoizationHelper(s, t, m, n, dp);
    }

    static int memoizationHelper(String s, String t, int i, int j, int[][] dp) {
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return dp[i][j] = memoizationHelper(s, t, i - 1, j - 1, dp) + memoizationHelper(s, t, i - 1, j, dp);
        } else {
            return dp[i][j] = memoizationHelper(s, t, i - 1, j, dp);
        }
    }

    //TC: O(m * n), SC: O(m * n)
    static int numDistinctWithTabulation(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int j = 1; j <= n; j++) dp[0][j] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}