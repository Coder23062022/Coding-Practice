package Krish.src.DynamicProgramming.DpOnGrids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/triangle/
//Video source: https://www.youtube.com/watch?v=SrP-PiLSYC0&ab_channel=takeUforward

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));

        int[][] triangleArray = triangle.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        System.out.println(minimumTotalWithRecursion(triangleArray));
        System.out.println(minimumTotalWithMemoization(triangleArray));
        System.out.println(minimumTotalWithTabulation(triangleArray));
    }

    //TC: O(2^n*n), //SC: O(n), n = path length <TLE>
    static int minimumTotalWithRecursion(int[][] grid) {
        return minimumTotalHelperWithRecursion(grid, 0, 0, grid.length);
    }

    static int minimumTotalHelperWithRecursion(int[][] grid, int i, int j, int n) {
        if (i == n - 1) return grid[n - 1][j];

        int down = grid[i][j] + minimumTotalHelperWithRecursion(grid, i + 1, j, n);
        int diagonal = grid[i][j] + minimumTotalHelperWithRecursion(grid, i + 1, j + 1, n);

        return Math.min(down, diagonal);
    }

    //TC: O(n*n), //SC: O((n-1)+(n-1)) + O(n*n)
    static int minimumTotalWithMemoization(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minimumTotalHelperWithMemoization(grid, 0, 0, n, dp);
    }

    static int minimumTotalHelperWithMemoization(int[][] grid, int i, int j, int n, int[][] dp) {
        if (i == n - 1) return grid[n - 1][j];

        if (dp[i][j] != -1) return dp[i][j];

        int down = grid[i][j] + minimumTotalHelperWithMemoization(grid, i + 1, j, n, dp);
        int diagonal = grid[i][j] + minimumTotalHelperWithMemoization(grid, i + 1, j + 1, n, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

    //TC: O(n*n), //SC: O(n*n)
    static int minimumTotalWithTabulation(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) dp[n - 1][j] = grid[n - 1][j];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = grid[i][j] + dp[i + 1][j];
                int diagonal = grid[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    //TC: O(n*n), //SC: O(n)
    static int minimumTotalWithSpaceOptimization(int[][] grid) {
        int n = grid.length;
        int[] front = new int[n];
        int[] curr = new int[n];

        for (int j = 0; j < n; j++) front[j] = grid[n - 1][j];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = grid[i][j] + front[j];
                int diagonal = grid[i][j] + front[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            front = curr.clone();
        }
        return front[0];
    }
}
