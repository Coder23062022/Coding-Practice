package Krish.src.DynamicProgramming.SubsequencesUnboundedKnapsackBased;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
//Video source: https://www.youtube.com/watch?v=aycn9KO8_Ls&t=3s&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=OgvOZ6OrJoY&ab_channel=takeUforward

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {6, 1, 7, 7};
        int capacity = 8;
        System.out.println(unBoundedknapsackWithRecursion(capacity, val, wt));
        System.out.println(unBoundedKnapsackWithMemoization(capacity, val, wt));
        System.out.println(unBoundedKnapsackWithTabulation(capacity, val, wt));
        System.out.println(unBoundedKnapsackWithSpaceOptimization(capacity, val, wt));
    }

    //TC: O(2^n), SC: O(n)
    static int unBoundedknapsackWithRecursion(int W, int[] val, int[] wt) {
        int n = wt.length;
        return knapsackHelper(W, val, wt, n);
    }

    static int knapsackHelper(int W, int[] val, int[] wt, int n) {
        if (n == 0 || W == 0) return 0;

        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsackHelper(W - wt[n - 1], val, wt, n), knapsackHelper(W, val, wt, n - 1));
        } else {
            return knapsackHelper(W, val, wt, n - 1);
        }
    }

    //TC: O(n*W), SC: O(n*W)
    //<<<<<<<<<<<Top-Down>>>>>>>>>>>>>>
    static int unBoundedKnapsackWithMemoization(int W, int[] val, int[] wt) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1); //Fills each row with the value -1
        return knapsackHelperWithMemoization(W, val, wt, n, dp);
    }

    static int knapsackHelperWithMemoization(int W, int[] val, int[] wt, int n, int[][] dp) {
        if (n == 0 || W == 0) return 0;

        if (dp[n][W] != -1) return dp[n][W];

        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(val[n - 1] + knapsackHelperWithMemoization(W - wt[n - 1], val, wt, n, dp), knapsackHelperWithMemoization(W, val, wt, n - 1, dp));
        } else {
            dp[n][W] = knapsackHelperWithMemoization(W, val, wt, n - 1, dp);
        }
        return dp[n][W];
    }

    //TC: O(n*W), SC: O(n*W)
    //<<<<<<<<<<<Bottom-Up>>>>>>>>>>>>>>
    static int unBoundedKnapsackWithTabulation(int W, int[] val, int[] wt) {
        int n = wt.length;
        if (n == 0 || W == 0) return 0;

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    //TC: O(n*W), SC: O(W)
    static int unBoundedKnapsackWithSpaceOptimization(int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];
        dp[0] = 0;
        for (int i = 1; i <= wt.length; i++) {
            for (int j = wt[i - 1]; j <= W; j++) {
                dp[j] = Math.max(val[i - 1] + dp[j - wt[i - 1]], dp[j]);
            }
        }
        return dp[W];
    }
}