package Krish.src.DynamicProgramming.DpOnStocks;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//Video source: https://www.youtube.com/watch?v=-uQGzhYj8BQ&ab_channel=takeUforward

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfitWithRecursion(prices));
        System.out.println(maxProfitWithMemoization(prices));
        System.out.println(maxProfitWithTabulation(prices));
        System.out.println(maxProfitWithSpaceOptimization(prices));

        System.out.println(maxProfitWithTransactionNumberMemoization(prices));
        System.out.println(maxProfitWithTransactionNumberTabulation(prices));
        System.out.println(maxProfitWithTransactionNumberSpaceOptimization(prices));

        System.out.println(maxProfitWithGreedy(prices));
    }

    //TC: O(2^n), SC: O(n) <It will give you TLE>
    static int maxProfitWithRecursion(int[] prices) {
        return recursionHelper(0, 1, prices, 2);
    }

    static int recursionHelper(int i, int buy, int[] prices, int capacity) {
        if (i == prices.length) return 0;
        if (capacity == 0) return 0;
        if (buy == 1) {
            return Math.max(-prices[i] + recursionHelper(i + 1, 0, prices, capacity), recursionHelper(i + 1, 1, prices, capacity));
        } else {
            return Math.max(prices[i] + recursionHelper(i + 1, 1, prices, capacity - 1), recursionHelper(i + 1, 0, prices, capacity));
        }
    }

    //TC: O(n*2*3), SC: O(n*2*3)
    static int maxProfitWithMemoization(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int[][] dp2 : dp) {
            for (int[] dp1 : dp2) {
                Arrays.fill(dp1, -1);
            }
        }
        return memoizationHelper(0, 1, prices, n, dp, 2);
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

    //TC: O(n*2*3), SC: O(n*2*3)
    static int maxProfitWithTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        dp[index][buy][cap] = Math.max(-prices[index] + dp[index + 1][0][cap], dp[index + 1][1][cap]);
                    } else {
                        dp[index][buy][cap] = Math.max(prices[index] + dp[index + 1][1][cap - 1], dp[index + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    //TC: O(n*2*3), SC: O(2*3)=O(1)
    static int maxProfitWithSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(-prices[index] + prev[0][cap], prev[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(prices[index] + prev[1][cap - 1], prev[0][cap]);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][2];
    }

    ////////////////////////////////////////////////ANOTHER WAY TO SOLVE: WITH TRANSACTION NUMBER///////////////////////////////////////
    //TC: O(n*4), SC: O(n*4)
    static int maxProfitWithTransactionNumberMemoization(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoizationHelperWithTransactionNumber(0, 0, prices, n, dp);
    }

    static int memoizationHelperWithTransactionNumber(int i, int trans, int[] prices, int n, int[][] dp) {
        if (i == n || trans == 4) return 0;
        if (dp[i][trans] != -1) return dp[i][trans];

        if (trans % 2 == 0) {
            dp[i][trans] = Math.max(-prices[i] + memoizationHelperWithTransactionNumber(i + 1, trans + 1, prices, n, dp), memoizationHelperWithTransactionNumber(i + 1, trans, prices, n, dp));
        } else {
            dp[i][trans] = Math.max(prices[i] + memoizationHelperWithTransactionNumber(i + 1, trans + 1, prices, n, dp), memoizationHelperWithTransactionNumber(i + 1, trans, prices, n, dp));
        }
        return dp[i][trans];
    }

    //TC: O(n*4), SC: O(n*4)
    static int maxProfitWithTransactionNumberTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][5];
        for (int j = 0; j <= 4; j++) dp[n][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][4] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int trans = 0; trans <= 3; trans++) {
                if (trans % 2 == 0) {
                    dp[index][trans] = Math.max(-prices[index] + dp[index + 1][trans + 1], dp[index + 1][trans]);
                } else {
                    dp[index][trans] = Math.max(prices[index] + dp[index + 1][trans + 1], dp[index + 1][trans]);
                }
            }
        }
        return dp[0][0];
    }

    //TC: O(n*4), SC: O(1)
    static int maxProfitWithTransactionNumberSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[] prev = new int[5];
        int[] curr = new int[5];

        for (int index = n - 1; index >= 0; index--) {
            for (int trans = 0; trans <= 3; trans++) {
                if (trans % 2 == 0) {
                    curr[trans] = Math.max(-prices[index] + prev[trans + 1], prev[trans]);
                } else {
                    curr[trans] = Math.max(prices[index] + prev[trans + 1], prev[trans]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }

    //TC: O(n), SC: O(1)
    static int maxProfitWithGreedy(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE, minPrice2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for (int currPrice : prices) {
            minPrice1 = Math.min(currPrice, minPrice1);
            profit1 = Math.max(profit1, currPrice - minPrice1);
            minPrice2 = Math.min(minPrice2, currPrice - profit1);
            profit2 = Math.max(profit2, currPrice - minPrice2);
        }
        return profit2;
    }
}