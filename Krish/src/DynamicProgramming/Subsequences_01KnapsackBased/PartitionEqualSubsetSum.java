package Krish.src.DynamicProgramming.Subsequences_01KnapsackBased;

//Problem: https://leetcode.com/problems/partition-equal-subset-sum/
//Video source: https://www.youtube.com/watch?v=UmMh7xp07kY&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=7win3dcgo3k&ab_channel=takeUforward

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartitionWithMemoization(nums));
        System.out.println(canPartitionWithTabulation(nums));
        System.out.println(canPartitionWithSpaceOptimizedTabulation(nums));
    }

    //TC: O(n*sum), SC: O(n*sum)
    static boolean canPartitionWithMemoization(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int n = nums.length;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        return canPartitionHelperWithMemoization(nums, sum / 2, n, dp);
    }

    static boolean canPartitionHelperWithMemoization(int[] arr, int sum, int n, Boolean[][] dp) {
        if (sum == 0) return true; //empty subset
        if (n == 0) return false;

        if (dp[n][sum] != null) return dp[n][sum];

        if (arr[n - 1] <= sum) {
            dp[n][sum] = canPartitionHelperWithMemoization(arr, sum - arr[n - 1], n - 1, dp) ||
                    canPartitionHelperWithMemoization(arr, sum, n - 1, dp);
        } else {
            dp[n][sum] = canPartitionHelperWithMemoization(arr, sum, n - 1, dp);
        }
        return dp[n][sum];
    }

    //TC: O(n*sum), SC: O(n*sum)
    static boolean canPartitionWithTabulation(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        return callSubsetSum(nums, sum / 2);
    }

    static boolean callSubsetSum(int[] arr, int sum) {
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

    //TC: O(n*sum), SC: O(sum)
    static boolean canPartitionWithSpaceOptimizedTabulation(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}