package Krish.src.DynamicProgramming.Subsequences_01KnapsackBased;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
//Video source: https://www.youtube.com/watch?v=_gPcYovP7wc&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=fWX9xDmIzRI&ab_channel=takeUforward

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSumWithMemoization(arr, sum));
        System.out.println(isSubsetSumWithTabulation(arr, sum));
        System.out.println(isSubsetSumWithSpaceOptimizedTabulation(arr, sum));
    }

    //TC: O(n*sum), SC: O(n*sum)
    static Boolean isSubsetSumWithMemoization(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (boolean[] row : dp) Arrays.fill(row, false);
        return isSubsetSumHelperWithMemoization(arr, sum, n, dp);
    }

    static Boolean isSubsetSumHelperWithMemoization(int[] arr, int sum, int n, boolean[][] dp) {
        if (sum == 0) return true; //empty subset
        if (n == 0) return false;

        if (dp[n][sum]) return true;

        if (arr[n - 1] <= sum) {
            dp[n][sum] = isSubsetSumHelperWithMemoization(arr, sum - arr[n - 1], n - 1, dp) ||
                    isSubsetSumHelperWithMemoization(arr, sum, n - 1, dp);
        } else {
            dp[n][sum] = isSubsetSumHelperWithMemoization(arr, sum, n - 1, dp);
        }
        return dp[n][sum];
    }

    //TC: O(n*sum), SC: O(n*sum)
    static Boolean isSubsetSumWithTabulation(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    static Boolean isSubsetSumWithSpaceOptimizedTabulation(int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int a : arr) {
            for (int j = sum; j >= a; j--) {
                dp[j] = dp[j] || dp[j - a];
            }
        }
        return dp[sum];
    }
}