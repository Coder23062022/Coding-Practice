package Krish.src.DynamicProgramming.DpOnGrids;

//Problem: https://leetcode.com/problems/minimum-path-sum/
//Video source: https://www.youtube.com/watch?v=_rgTlyky1uQ&ab_channel=takeUforward

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSumWithRecursion(grid));
        System.out.println(minPathSumWithMemoization(grid));
        System.out.println(minPathSumWithTabulation(grid));
    }

    //TC: O(2^m*n), //SC: O(n), n = path length
    static int minPathSumWithRecursion(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return minPathSumHelperWithRecursion(grid, m - 1, n - 1);
    }

    static int minPathSumHelperWithRecursion(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) return grid[m][n];
        if (m < 0 || n < 0) return (int) 1e9;

        int up = grid[m][n] + minPathSumHelperWithRecursion(grid, m - 1, n);
        int left = grid[m][n] + minPathSumHelperWithRecursion(grid, m, n - 1);
        return Math.min(up, left);
    }

    //TC: O(m*n), //SC: O((m-1)+(n-1)) + O(m*n)
    static int minPathSumWithMemoization(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minPathSumHelperWithMemoization(grid, m - 1, n - 1, dp);
    }

    static int minPathSumHelperWithMemoization(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return grid[m][n];
        if (m < 0 || n < 0) return (int) 1e9;

        if (dp[m][n] != -1) return dp[m][n];

        int up = grid[m][n] + minPathSumHelperWithMemoization(grid, m - 1, n, dp);
        int left = grid[m][n] + minPathSumHelperWithMemoization(grid, m, n - 1, dp);
        return dp[m][n] = Math.min(up, left);
    }

    //TC: O(m*n), //SC: O(m*n)
    static int minPathSumWithTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up, left;
                    if (i > 0) up = grid[i][j] + dp[i - 1][j];
                    else up = (int) 1e9;
                    if (j > 0) left = grid[i][j] + dp[i][j - 1];
                    else left = (int) 1e9;
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}