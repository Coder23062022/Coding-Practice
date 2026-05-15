package Krish.src.DSAlgo.DynamicProgramming.DpOnStocks;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//Video source: https://www.youtube.com/watch?v=IGIe46xw3YY&t=11s&ab_channel=takeUforward
//TC: O(n*2)
//SC: O(n*2)

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitWithTabulation(prices));
        System.out.println(maxProfitWithTabulationWithSingleLoop(prices));
    }

    //TC: O(n*2), SC: O(n*2) + Recursion stack space
    static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoizationHelper(0, 1, prices, n, dp);
    }

    static int memoizationHelper(int i, int buy, int[] prices, int n, int[][] dp) {
        if (i >= n) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        if (buy == 1) {
            dp[i][buy] = Math.max(-prices[i] + memoizationHelper(i + 1, 0, prices, n, dp), memoizationHelper(i + 1, 1, prices, n, dp));
        } else {
            dp[i][buy] = Math.max(prices[i] + memoizationHelper(i + 2, 1, prices, n, dp), memoizationHelper(i + 1, 0, prices, n, dp));
        }
        return dp[i][buy];
    }

    //TC: O(n*2), SC: O(n*2)
    static int maxProfitWithTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[index][buy] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    dp[index][buy] = Math.max(prices[index] + dp[index + 2][1], dp[index + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    //TC: O(n), SC: O(n*2)
    static int maxProfitWithTabulationWithSingleLoop(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            dp[index][1] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
            dp[index][0] = Math.max(prices[index] + dp[index + 2][1], dp[index + 1][0]);
        }
        return dp[0][1];
    }
}