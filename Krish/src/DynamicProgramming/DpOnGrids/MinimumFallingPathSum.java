package Krish.src.DynamicProgramming.DpOnGrids;

//Problem: https://leetcode.com/problems/minimum-falling-path-sum/
//Video source: https://www.youtube.com/watch?v=N_aJ5qQbYA0&ab_channel=takeUforward

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSumWithRecursion(matrix));
        System.out.println(minFallingPathSumWithMemoization(matrix));
        System.out.println(minFallingPathSumWithTabulation(matrix));
        System.out.println(minFallingPathSumWithSpaceOptimization(matrix));
    }

    //TC: O(3^n), SC: O(n) <TLE>
    static int minFallingPathSumWithRecursion(int[][] matrix) {
        int n = matrix.length;
        int minSum = (int) 1e9;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, minFallingPathSumHelperWithRecursion(matrix, n - 1, j));
        }
        return minSum;
    }

    static int minFallingPathSumHelperWithRecursion(int[][] matrix, int i, int j) {
        if (j < 0 || j >= matrix.length) return (int) 1e9;
        if (i == 0) return matrix[0][j];

        int up = matrix[i][j] + minFallingPathSumHelperWithRecursion(matrix, i - 1, j);
        int leftDiagonal = matrix[i][j] + minFallingPathSumHelperWithRecursion(matrix, i - 1, j - 1);
        int rightDiagonal = matrix[i][j] + minFallingPathSumHelperWithRecursion(matrix, i - 1, j + 1);

        return Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    //TC: O(n*n), SC: O(n) + O(n*n) <TLE>
    static int minFallingPathSumWithMemoization(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int minSum = (int) 1e9;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, minFallingPathSumHelperWithMemoization(matrix, n - 1, j, dp));
        }
        return minSum;
    }

    static int minFallingPathSumHelperWithMemoization(int[][] matrix, int i, int j, int[][] dp) {
        if (j < 0 || j >= matrix.length) return (int) 1e9;
        if (i == 0) return matrix[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + minFallingPathSumHelperWithMemoization(matrix, i - 1, j, dp);
        int leftDiagonal = matrix[i][j] + minFallingPathSumHelperWithMemoization(matrix, i - 1, j - 1, dp);
        int rightDiagonal = matrix[i][j] + minFallingPathSumHelperWithMemoization(matrix, i - 1, j + 1, dp);

        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    //TC: O(n*n), SC: O(n*n)
    static int minFallingPathSumWithTabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal, rightDiagonal;
                if (j - 1 >= 0) leftDiagonal = matrix[i][j] + dp[i - 1][j - 1];
                else leftDiagonal = (int) 1e9;

                if (j + 1 < n) rightDiagonal = matrix[i][j] + dp[i - 1][j + 1];
                else rightDiagonal = (int) 1e9;

                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));

            }
        }

        int minSum = (int) 1e9;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }
        return minSum;
    }

    //TC: O(n*n), SC: O(n)
    static int minFallingPathSumWithSpaceOptimization(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int j = 0; j < n; j++) prev[j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + prev[j];

                int leftDiagonal, rightDiagonal;
                if (j - 1 >= 0) leftDiagonal = matrix[i][j] + prev[j - 1];
                else leftDiagonal = (int) 1e9;

                if (j + 1 < n) rightDiagonal = matrix[i][j] + prev[j + 1];
                else rightDiagonal = (int) 1e9;

                curr[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            prev = curr.clone();
        }

        int minSum = (int) 1e9;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, prev[j]);
        }
        return minSum;
    }
}