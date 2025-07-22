package Krish.src.DynamicProgramming.DpOnStocks;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
//Video source: https://www.youtube.com/watch?v=k4eK-vEmnKg&ab_channel=takeUforward
//TC: O(n*2)
//SC: O(n*2)

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfitWithMemoization(prices, fee));
    }

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
}