package Krish.src.DynamicProgramming.DpOn1D;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/problems/geek-jump/1
//Video source: https://www.youtube.com/watch?v=EgG3jsGoPvQ&t=2184s&ab_channel=takeUforward

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {20, 30, 40, 20};
        System.out.println(minCostWithRecursion(heights));
        System.out.println(minCostWithMemoization(heights));
        System.out.println(minCostWithTabulation(heights));
        System.out.println(minCostWithSpaceOptimization(heights));
    }

    //TC: O(2^n), SC: O(n)
    static int minCostWithRecursion(int[] height) {
        int n = height.length;
        return minCostHelperWithRecursion(height, n - 1);
    }

    static int minCostHelperWithRecursion(int[] height, int index) {
        if (index == 0) return 0;

        int oneJump = minCostHelperWithRecursion(height, index - 1) + Math.abs(height[index] - height[index - 1]);
        int twoJumps = Integer.MAX_VALUE;
        if (index > 1)
            twoJumps = minCostHelperWithRecursion(height, index - 2) + Math.abs(height[index] - height[index - 2]);

        return Math.min(twoJumps, oneJump);
    }

    //TC: O(n), SC: O(n) + O(n)
    static int minCostWithMemoization(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCostHelperWithMemoization(height, n - 1, dp);
    }

    static int minCostHelperWithMemoization(int[] height, int index, int[] dp) {
        if (index == 0) return 0;

        if (dp[index] != -1) return dp[index];

        int oneJump = minCostHelperWithMemoization(height, index - 1, dp) + Math.abs(height[index] - height[index - 1]);
        int twoJumps = Integer.MAX_VALUE;
        if (index > 1)
            twoJumps = minCostHelperWithMemoization(height, index - 2, dp) + Math.abs(height[index] - height[index - 2]);

        return dp[index] = Math.min(twoJumps, oneJump);
    }

    //TC: O(n), SC: O(n)
    static int minCostWithTabulation(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int index = 1; index < n; index++) {
            int oneJump = dp[index - 1] + Math.abs(height[index] - height[index - 1]);
            int twoJumps = Integer.MAX_VALUE;
            if (index > 1) twoJumps = dp[index - 2] + Math.abs(height[index] - height[index - 2]);
            dp[index] = Math.min(twoJumps, oneJump);
        }
        return dp[n - 1];
    }

    //TC: O(n), SC: O(1)
    static int minCostWithSpaceOptimization(int[] height) {
        int n = height.length;
        int prev = 0, prev2 = 0;

        for (int index = 1; index < n; index++) {
            int oneJump = prev + Math.abs(height[index] - height[index - 1]);
            int twoJumps = Integer.MAX_VALUE;
            if (index > 1) twoJumps = prev2 + Math.abs(height[index] - height[index - 2]);
            int curr = Math.min(twoJumps, oneJump);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
