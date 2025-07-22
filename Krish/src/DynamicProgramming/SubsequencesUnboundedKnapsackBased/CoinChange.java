package Krish.src.DynamicProgramming.SubsequencesUnboundedKnapsackBased;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/coin-change/
//Video source: https://www.youtube.com/watch?v=I-l6PBeERuc&t=481s&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=myPeWb3Y68A&ab_channel=takeUforward

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 3, 4, 5}; //{1, 2, 5}
        int amount = 7; //11
        System.out.println(changeWithMemoization(amount, coins));
        System.out.println(changeWithTabulation(amount, coins));
        System.out.println(coinChangeWithSpaceOptimization(coins, amount));
    }

    //TC: O(n*amount), SC: O(n*amount)
    static int changeWithMemoization(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return changeHelperWithMemoization(coins, amount, n, dp);
    }

    static int changeHelperWithMemoization(int[] coins, int amount, int n, int[][] dp) {
        if (n == 0) return Integer.MAX_VALUE - 1;
        if (amount == 0) return 0;

        if (dp[n][amount] != -1) return dp[n][amount];

        if (coins[n - 1] <= amount) {
            dp[n][amount] = Math.min(1 + changeHelperWithMemoization(coins, amount - coins[n - 1], n, dp), changeHelperWithMemoization(coins, amount, n - 1, dp));
        } else {
            dp[n][amount] = changeHelperWithMemoization(coins, amount, n - 1, dp);
        }
        return dp[n][amount];
    }

    //TC: O(n*amount), SC: O(n*amount)
    static int changeWithTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int j = 0; j <= amount; j++) dp[0][j] = Integer.MAX_VALUE - 1;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }

    //TC: O(n*amount), SC: O(amount)
    static int coinChangeWithSpaceOptimization(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(1 + dp[j - coin], dp[j]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}