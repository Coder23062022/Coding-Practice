package Krish.src.DynamicProgramming.DpOnStocks;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
//Video source: https://www.youtube.com/watch?v=IV1dHbk5CDc&t=355s&ab_channel=takeUforward

public class BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        int k = 2;
        System.out.println(maxProfitWithRecursion(prices, k));
        System.out.println(maxProfitWithMemoization(prices, k));
        System.out.println(maxProfitWithTabulation(prices, k));
        System.out.println(maxProfitWithSpaceOptimization(prices, k));
    }

    //TC: O(2^n), SC: O(n) <It will give you TLE>
    static int maxProfitWithRecursion(int[] prices, int k) {
        return recursionHelper(0, 1, prices, k);
    }

    static int recursionHelper(int i, int buy, int[] prices, int capacity) {
        if (i == prices.length || capacity == 0) return 0;
        if (buy == 1) {
            return Math.max(-prices[i] + recursionHelper(i + 1, 0, prices, capacity), recursionHelper(i + 1, 1, prices, capacity));
        } else {
            return Math.max(prices[i] + recursionHelper(i + 1, 1, prices, capacity - 1), recursionHelper(i + 1, 0, prices, capacity));
        }
    }

    //TC: O(n*2*k), SC: O(n*2*k)
    static int maxProfitWithMemoization(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int[][] dp2 : dp) {
            for (int[] dp1 : dp2) {
                Arrays.fill(dp1, -1);
            }
        }
        return memoizationHelper(0, 1, prices, n, dp, k);
    }

    static int memoizationHelper(int i, int buy, int[] prices, int n, int[][][] dp, int capacity) {
        if (i == n || capacity == 0) return 0;
        if (dp[i][buy][capacity] != -1) return dp[i][buy][capacity];

        if (buy == 1) {
            dp[i][buy][capacity] = Math.max(-prices[i] + memoizationHelper(i + 1, 0, prices, n, dp, capacity), memoizationHelper(i + 1, 1, prices, n, dp, capacity));
        } else {
            dp[i][buy][capacity] = Math.max(prices[i] + memoizationHelper(i + 1, 1, prices, n, dp, capacity - 1), memoizationHelper(i + 1, 0, prices, n, dp, capacity));
        }
        return dp[i][buy][capacity];
    }

    //TC: O(n*2*k), SC: O(n*2*k)
    static int maxProfitWithTabulation(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        dp[index][buy][cap] = Math.max(-prices[index] + dp[index + 1][0][cap], dp[index + 1][1][cap]);
                    } else {
                        dp[index][buy][cap] = Math.max(prices[index] + dp[index + 1][1][cap - 1], dp[index + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }

    //TC: O(n*2*k), SC: O(1)
    static int maxProfitWithSpaceOptimization(int[] prices, int k) {
        int n = prices.length;
        int[][] prev = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(-prices[index] + prev[0][cap], prev[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(prices[index] + prev[1][cap - 1], prev[0][cap]);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][k];
    }
}