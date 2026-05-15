package Krish.src.DSAlgo.DynamicProgramming.DpOnStocks;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
//Video source: https://www.youtube.com/watch?v=k4eK-vEmnKg&ab_channel=takeUforward

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfitWithMemoization(prices, fee));
        System.out.println(maxProfitWithTabulation(prices, fee));
        System.out.println(maxProfitWithTabulationWithSingleLoop(prices, fee));
        System.out.println(maxProfitWithSpaceOptimization(prices, fee));
    }

    //TC: O(n*2), SC: O(n*2) + Recursion stack space
    static int maxProfitWithMemoization(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoizationHelper(0, 1, prices, n, dp, fee);
    }

    static int memoizationHelper(int i, int buy, int[] prices, int n, int[][] dp, int fee) {
        if (i == n) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        if (buy == 1) {
            dp[i][buy] = Math.max(-prices[i] + memoizationHelper(i + 1, 0, prices, n, dp, fee), memoizationHelper(i + 1, 1, prices, n, dp, fee));
        } else {
            dp[i][buy] = Math.max((prices[i] - fee) + memoizationHelper(i + 1, 1, prices, n, dp, fee), memoizationHelper(i + 1, 0, prices, n, dp, fee));
        }
        return dp[i][buy];
    }

    //TC: O(n*2), SC: O(n*2)
    static int maxProfitWithTabulation(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[index][buy] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    dp[index][buy] = Math.max(prices[index] - fee + dp[index + 1][1], dp[index + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    //TC: O(n), SC: O(n*2)
    static int maxProfitWithTabulationWithSingleLoop(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            dp[index][1] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
            dp[index][0] = Math.max(prices[index] - fee + dp[index + 1][1], dp[index + 1][0]);
        }
        return dp[0][1];
    }

    //TC: O(n*2), SC: O(1)
    static int maxProfitWithSpaceOptimization(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];
        int[] curr = new int[2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[index] + prev[0], prev[1]);
                } else {
                    curr[buy] = Math.max(prices[index] - fee + prev[1], prev[0]);
                }
            }
            prev = curr;
        }
        return prev[1];
    }

    //TC: O(n), SC: O(1)
    static int maxProfitWithSpaceOptimizationWithSingleLoop(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];
        int[] curr = new int[2];

        for (int index = n - 1; index >= 0; index--) {
            curr[1] = Math.max(-prices[index] + prev[0], prev[1]);
            curr[0] = Math.max(prices[index] - fee + prev[1], prev[0]);
            prev = curr;
        }
        return prev[1];
    }
}