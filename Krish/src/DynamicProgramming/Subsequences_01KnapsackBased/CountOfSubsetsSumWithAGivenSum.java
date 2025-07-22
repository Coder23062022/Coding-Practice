package Krish.src.DynamicProgramming.Subsequences_01KnapsackBased;

//Problem: https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
//Video source: https://www.youtube.com/watch?v=F7wqWbqYn9g&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=ZHyb-A2Mte4&ab_channel=takeUforward

public class CountOfSubsetsSumWithAGivenSum {
    public static void main(String[] args) {
        int[] arr = {28, 4, 3, 27, 0, 24, 26};
        int target = 24;
        System.out.println(perfectSumWithTabulation(arr, target));
        System.out.println(perfectSumWithSpaceOptimizedTabulation(arr, target));
    }

    //TC: O(n*target), SC: O(n*target)
    static int perfectSumWithTabulation(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    //TC: O(n*target), SC: O(target)
    static int perfectSumWithSpaceOptimizedTabulation(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}