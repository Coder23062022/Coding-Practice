package Krish.src.DynamicProgramming.Subsequences_01KnapsackBased;

//Problem: https://leetcode.com/problems/target-sum/
//Video source: https://www.youtube.com/watch?v=Hw6Ygp3JBYw&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=b3GD8263-PQ&ab_channel=takeUforward
//TC: O(n*target)
//SC: O(n*target)

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum + target) % 2 != 0) return 0;
        if (sum + target < 0) return 0;
        int sum1 = (sum + target) / 2;
        return callCountOfSubsetSum(nums, sum1);
    }

    static int callCountOfSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}