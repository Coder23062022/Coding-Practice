package Krish.src.DynamicProgramming.SubsequencesUnboundedKnapsackBased;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/problems/rod-cutting0840/1
//Video source: https://www.youtube.com/watch?v=SZqAQLjDsag&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=mO8XpGoJwuo&t=1075s&ab_channel=takeUforward
//Time complexity: O(n^2)
//Space complexity: O(n^2)

public class RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(callUnboundedKnapsackWithMemoization(price));
        System.out.println(callUnboundedKnapsackWithTabulation(price));
    }

    static int callUnboundedKnapsackWithMemoization(int[] price) {
        int n = price.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return knapsackHelperWithMemoization(n, price, n, dp);
    }

    static int knapsackHelperWithMemoization(int N, int[] price, int n, int[][] dp) {
        if (n == 0) return 0;

        if (dp[n][N] != -1) return dp[n][N];

        if (n <= N) {
            dp[n][N] = Math.max(price[n - 1] + knapsackHelperWithMemoization(N - n, price, n, dp), knapsackHelperWithMemoization(N, price, n - 1, dp));
        } else {
            dp[n][N] = knapsackHelperWithMemoization(N, price, n - 1, dp);
        }
        return dp[n][N];
    }

    static int callUnboundedKnapsackWithTabulation(int[] price) {
        int n = price.length;
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                if (i <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }
}