package Krish.src.DynamicProgramming.DPOnStrings;

//Problem: https://leetcode.com/problems/longest-common-subsequence
//Video source: https://www.youtube.com/watch?v=NPZn9jBrX8U&ab_channel=takeUforward

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(lcsWithRecursion(str1, str2));
        System.out.println(lcsWithMemoization(str1, str2));
        System.out.println(lcsWithTabulation(str1, str2));
        System.out.println(lcsWithSpaceOptimization(str1, str2));
    }

    //TC: O(2 ^ min(m, n)), SC: O(min(m, n))
    static int lcsWithRecursion(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        return lcsHelperWithRecursion(str1, str2, m, n);
    }

    static int lcsHelperWithRecursion(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) return 0;

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return 1 + lcsHelperWithRecursion(str1, str2, m - 1, n - 1);
        else
            return Math.max(lcsHelperWithRecursion(str1, str2, m, n - 1), lcsHelperWithRecursion(str1, str2, m - 1, n));
    }

    //TC: O(m * n), SC: O(m * n) + O(m + n)
    static int lcsWithMemoization(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return lcsHelperWithMemoization(str1, str2, m, n, dp);
    }

    static int lcsHelperWithMemoization(String str1, String str2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return dp[m][n] = 1 + lcsHelperWithMemoization(str1, str2, m - 1, n - 1, dp);
        else
            return dp[m][n] = Math.max(lcsHelperWithMemoization(str1, str2, m, n - 1, dp), lcsHelperWithMemoization(str1, str2, m - 1, n, dp));
    }

    //TC: O(m * n), SC: O(m * n)
    static int lcsWithTabulation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                    //If both the characters are same then add 1 with the diagonal value of the matrix. Otherwise, take the maximum
                    //value of [i][j - 1] and [i - 1][j] position.
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }

    //TC: O(m * n), SC: O(2n)
    static int lcsWithSpaceOptimization(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) curr[j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(curr[j - 1], prev[j]);
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}