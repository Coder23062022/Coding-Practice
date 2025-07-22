package Krish.src.DynamicProgramming.SubsequencesUnboundedKnapsackBased;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/coin-change-ii/
//Video source: https://www.youtube.com/watch?v=I4UR2T6Ro3w&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=HgyouUi11zk&ab_channel=takeUforward

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(changeWithMemoization(amount, coins));
        System.out.println(changeWithTabulation(amount, coins));
        System.out.println(changeWithSpaceOptimization(amount, coins));
    }

    //TC: O(n*amount), SC: O(n*amount)
    static int changeWithMemoization(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return changeHelperWithMemoization(coins, amount, n, dp);
    }

    static int changeHelperWithMemoization(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0) return 1; //empty subset
        if (n == 0) return 0;

        if (dp[n][sum] != -1) return dp[n][sum];

        if (arr[n - 1] <= sum) {
            dp[n][sum] = changeHelperWithMemoization(arr, sum - arr[n - 1], n, dp) +
                    changeHelperWithMemoization(arr, sum, n - 1, dp);
        } else {
            dp[n][sum] = changeHelperWithMemoization(arr, sum, n - 1, dp);
        }
        return dp[n][sum];
    }

    //TC: O(n*amount), SC: O(n*amount)
    static int changeWithTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    //TC: O(n*amount), SC: O(amount)
    static long changeWithSpaceOptimization(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int j = coin; j <= amount; j++)
                dp[j] += dp[j - coin];
        return dp[amount];
    }
}