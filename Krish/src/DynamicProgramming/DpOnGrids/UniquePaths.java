package Krish.src.DynamicProgramming.DpOnGrids;

//Problem: https://leetcode.com/problems/unique-paths/
//Video source: https://www.youtube.com/watch?v=sdE0A2Oxofw&t=2667s&ab_channel=takeUforward
//Video source: https://www.youtube.com/watch?v=IlEsdxuD4lY&ab_channel=NeetCode

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePathsWithRecursion(m, n));
        System.out.println(uniquePathsWithMemoization(m, n));
        System.out.println(uniquePathsWithTabulation(m, n));
    }

    //TC: O(2^m*n), //SC: O(n), n = path length
    static int uniquePathsWithRecursion(int m, int n) {
        return uniquePathsHelperWithRecursion(m - 1, n - 1);
    }

    static int uniquePathsHelperWithRecursion(int m, int n) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        int up = uniquePathsHelperWithRecursion(m - 1, n);
        int left = uniquePathsHelperWithRecursion(m, n - 1);
        return up + left;
    }

    //TC: O(m*n), //SC: O((m-1)+(n-1)) + O(m*n)
    static int uniquePathsWithMemoization(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return uniquePathsHelperWithMemoization(m - 1, n - 1, dp);
    }

    static int uniquePathsHelperWithMemoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int up = uniquePathsHelperWithMemoization(m - 1, n, dp);
        int left = uniquePathsHelperWithMemoization(m, n - 1, dp);
        return dp[m][n] = up + left;
    }

    //TC: O(m*n), //SC: O(m*n)
    static int uniquePathsWithTabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}