package Krish.src.DynamicProgramming.DpOnGrids;

//Problem: https://leetcode.com/problems/unique-paths-ii/
//Video source: https://www.youtube.com/watch?v=TmhpgXScLyY&ab_channel=takeUforward

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstaclesRecursion(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesMemoization(obstacleGrid));
    }

    //TC: O(2^m*n), //SC: O(n), n = path length
    static int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePathsHelperWithRecursion(obstacleGrid, m - 1, n - 1);
    }

    static int uniquePathsHelperWithRecursion(int[][] obstacleGrid, int m, int n) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        int up = uniquePathsHelperWithRecursion(obstacleGrid, m - 1, n);
        int left = uniquePathsHelperWithRecursion(obstacleGrid, m, n - 1);
        return up + left;
    }

    //TC: O(m*n), //SC: O((m-1)+(n-1)) + O(m*n)
    static int uniquePathsWithObstaclesMemoization(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return uniquePathsHelperWithMemoization(obstacleGrid, m - 1, n - 1, dp);
    }

    static int uniquePathsHelperWithMemoization(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int up = uniquePathsHelperWithMemoization(obstacleGrid, m - 1, n, dp);
        int left = uniquePathsHelperWithMemoization(obstacleGrid, m, n - 1, dp);
        return dp[m][n] = up + left;
    }

    //TC: O(m*n), //SC: O(m*n)
    static int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
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