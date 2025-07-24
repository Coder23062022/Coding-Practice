package Krish.src.DynamicProgramming.DpOn1D;

import java.util.Arrays;

//Problem: https://takeuforward.org/plus/dsa/problems/frog-jump-with-k-distances
//Video source: https://www.youtube.com/watch?v=Kmh3rhyEtB8&t=506s&ab_channel=takeUforward

public class FrogJumpWithKDistance {
    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int k = 2;
        System.out.println(minCostWithRecursion(height, k));
        System.out.println(minCostWithMemoization(height, k));
        System.out.println(minCostWithTabulation(height, k));
    }

    //TC: O(n^k), SC: O(n)
    static int minCostWithRecursion(int[] height, int k) {
        int n = height.length;
        return minCostHelperWithRecursion(height, n - 1, k);
    }

    static int minCostHelperWithRecursion(int[] height, int index, int k) {
        if (index == 0) return 0;
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            int jump = Integer.MAX_VALUE;
            if (index - j >= 0)
                jump = minCostHelperWithRecursion(height, index - j, k) + Math.abs(height[index] - height[index - j]);
            minSteps = Math.min(minSteps, jump);
        }
        return minSteps;
    }

    //TC: O(n*k), SC: O(n) + O(n)
    static int minCostWithMemoization(int[] height, int k) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCostHelperWithMemoization(height, n - 1, k, dp);
    }

    static int minCostHelperWithMemoization(int[] height, int index, int k, int[] dp) {
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];

        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            int jump = Integer.MAX_VALUE;
            if (index - j >= 0)
                jump = minCostHelperWithMemoization(height, index - j, k, dp) + Math.abs(height[index] - height[index - j]);
            minSteps = Math.min(minSteps, jump);
        }
        return dp[index] = minSteps;
    }

    //TC: O(n*k), SC: O(n)
    static int minCostWithTabulation(int[] height, int k) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }
}