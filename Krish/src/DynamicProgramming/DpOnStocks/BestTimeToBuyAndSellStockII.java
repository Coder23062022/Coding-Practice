package Krish.src.DynamicProgramming.DpOnStocks;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//Video source: https://www.youtube.com/watch?v=nGJmxkUJQGs&ab_channel=takeUforward
//Video source: https://www.youtube.com/watch?v=3SJ3pUkPQMc&ab_channel=NeetCode

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitWithRecursion(prices));
        System.out.println(maxProfitWithMemoization(prices));
        System.out.println(maxProfitWithTabulation(prices));
        System.out.println(maxProfitWithSpaceOptimization(prices));
        System.out.println(maxProfitWithVariables(prices));
        System.out.println(maxProfitWithGreedy(prices));
    }

    //TC: O(2^n), SC: O(n) <It will give you TLE>
    static int maxProfitWithRecursion(int[] prices) {
        return recursionHelper(0, 1, prices);
    }

    static int recursionHelper(int i, int buy, int[] prices) {
        if (i == prices.length) return 0;
        if (buy == 1) {
            return Math.max(-prices[i] + recursionHelper(i + 1, 0, prices), recursionHelper(i + 1, 1, prices));
        } else {
            return Math.max(prices[i] + recursionHelper(i + 1, 1, prices), recursionHelper(i + 1, 0, prices));
        }
    }

    //TC: O(n*2), SC: O(n*2)
    static int maxProfitWithMemoization(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoizationHelper(0, 1, prices, n, dp);
    }

    static int memoizationHelper(int i, int buy, int[] prices, int n, int[][] dp) {
        if (i == n) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        if (buy == 1) {
            dp[i][buy] = Math.max(-prices[i] + memoizationHelper(i + 1, 0, prices, n, dp), memoizationHelper(i + 1, 1, prices, n, dp));
        } else {
            dp[i][buy] = Math.max(prices[i] + memoizationHelper(i + 1, 1, prices, n, dp), memoizationHelper(i + 1, 0, prices, n, dp));
        }
        return dp[i][buy];
    }

    //TC: O(n*2), SC: O(n*2)
    static int maxProfitWithTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 1) {
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    dp[i][j] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    //TC: O(n*2), SC: O(2)
    static int maxProfitWithSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];
        int[] curr = new int[2];
        prev[0] = prev[1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 1) {
                    curr[j] = Math.max(-prices[i] + prev[0], prev[1]);
                } else {
                    curr[j] = Math.max(prices[i] + prev[1], prev[0]);
                }
            }
            prev = curr;
        }
        return prev[1];
    }

    //TC: O(n), SC: O(1)
    static int maxProfitWithVariables(int[] prices) {
        int n = prices.length;
        int currBuy = 0, currNotBuy = 0, prevBuy = 0, prevNotBuy = 0;

        for (int i = n - 1; i >= 0; i--) {
            currBuy = Math.max(-prices[i] + prevNotBuy, prevBuy);
            currNotBuy = Math.max(prices[i] + prevBuy, prevNotBuy);
            prevBuy = currBuy;
            prevNotBuy = currNotBuy;
        }
        return prevBuy;
    }

    //TC: O(n), SC: O(1)
    static int maxProfitWithGreedy(int[] prices) {
        int profitFromPriceGain = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profitFromPriceGain += (prices[i] - prices[i - 1]);
            }
        }
        return profitFromPriceGain;
    }
}