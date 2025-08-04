package Krish.src.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/longest-increasing-subsequence/
//Video source: https://www.youtube.com/watch?v=ekcwMsSIzVc&ab_channel=takeUforward

public class LISWithDP {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLISWithRecursion(nums));
        System.out.println(lengthOfLISWithMemoization(nums));
        System.out.println(lengthOfLISWithTabulation(nums));
    }

    //TC: O(2^n), SC: O(n)
    static int lengthOfLISWithRecursion(int[] nums) {
        int n = nums.length;
        return recursionHelper(nums, n, 0, -1);
    }

    static int recursionHelper(int[] nums, int n, int index, int prev_index) {
        if (index == n) return 0;

        int maxLen = recursionHelper(nums, n, index + 1, prev_index); //not take
        if (prev_index == -1 || nums[index] > nums[prev_index]) { //take
            maxLen = Math.max(maxLen, 1 + recursionHelper(nums, n, index + 1, index));
        }
        return maxLen;
    }

    //TC: O(n^2), SC: O(n^2) + O(n)
    static int lengthOfLISWithMemoization(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoizationHelper(nums, n, 0, -1, dp);
    }

    static int memoizationHelper(int[] nums, int n, int index, int prev_index, int[][] dp) {
        if (index == n) return 0;
        if (dp[index][prev_index + 1] != -1) return dp[index][prev_index + 1];

        int maxLen = memoizationHelper(nums, n, index + 1, prev_index, dp); //not take
        if (prev_index == -1 || nums[index] > nums[prev_index]) { //take
            maxLen = Math.max(maxLen, 1 + memoizationHelper(nums, n, index + 1, index, dp));
        }
        return dp[index][prev_index + 1] = maxLen;
    }

    //TC: O(n^2), SC: O(n^2)
    static int lengthOfLISWithTabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        dp[n][n - 1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int prev_index = index - 1; prev_index >= -1; prev_index--) {
                int maxLen = dp[index + 1][prev_index + 1];
                if (prev_index == -1 || nums[index] > nums[prev_index]) {
                    maxLen = Math.max(maxLen, 1 + dp[index + 1][index + 1]);
                }
                dp[index][prev_index + 1] = maxLen;
            }
        }
        return dp[0][0];
    }
}