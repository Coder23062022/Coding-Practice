package Krish.src.DynamicProgramming.Subsequences_01KnapsackBased;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
//Video source: https://www.youtube.com/watch?v=kvyShbFVaY8&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=fJbIuhs24zQ&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=ntCGbPMeqgg&t=2335s&ab_channel=AdityaVerma

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {5, 4, 2, 3};
        int[] val = {10, 40, 30, 50};
        int W = 5;
        System.out.println(knapsackWithRecursion(W, val, wt));
        System.out.println(knapsackWithMemoization(W, val, wt));
        System.out.println(knapsackWithTabulation(W, val, wt));
        System.out.println(knapsackWithSpaceOptimizedTabulation(W, val, wt));
    }

    //TC: O(2^n), SC: O(n)
    static int knapsackWithRecursion(int W, int[] val, int[] wt) {
        int n = wt.length;
        return knapsackHelper(W, val, wt, n);
    }

    static int knapsackHelper(int W, int[] val, int[] wt, int n) {
        if (n == 0 || W == 0) return 0;

        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsackHelper(W - wt[n - 1], val, wt, n - 1), knapsackHelper(W, val, wt, n - 1));
        } else {
            return knapsackHelper(W, val, wt, n - 1);
        }
    }

    //TC: O(n*W), SC: O(n*W)
    //<<<<<<<<<<<Top-Down>>>>>>>>>>>>>>
    static int knapsackWithMemoization(int W, int[] val, int[] wt) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1); //Fills each row with the value -1
        return knapsackHelperWithMemoization(W, val, wt, n, dp);
    }

    static int knapsackHelperWithMemoization(int W, int[] val, int[] wt, int n, int[][] dp) {
        if (n == 0 || W == 0) return 0;

        if (dp[n][W] != -1) return dp[n][W];

        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(val[n - 1] + knapsackHelperWithMemoization(W - wt[n - 1], val, wt, n - 1, dp), knapsackHelperWithMemoization(W, val, wt, n - 1, dp));
        } else {
            dp[n][W] = knapsackHelperWithMemoization(W, val, wt, n - 1, dp);
        }
        return dp[n][W];
    }

    //TC: O(n*W), SC: O(n*W)
    //<<<<<<<<<<<Bottom-Up>>>>>>>>>>>>>>
    static int knapsackWithTabulation(int W, int[] val, int[] wt) {
        int n = wt.length;
        if (n == 0 || W == 0) return 0;

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    //TC: O(n*W), SC: O(W)
    //<<<<<<<<<<<Bottom-Up>>>>>>>>>>>>>>
    static int knapsackWithSpaceOptimizedTabulation(int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= wt.length; i++) {
            for (int j = W; j >= wt[i - 1]; j--) {
                if (wt[i - 1] <= j) {
                    dp[j] = Math.max(val[i - 1] + dp[j - wt[i - 1]], dp[j]);
                }
            }
        }
        return dp[W];
    }
}