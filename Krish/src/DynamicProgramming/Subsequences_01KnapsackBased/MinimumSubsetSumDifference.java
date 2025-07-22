package Krish.src.DynamicProgramming.Subsequences_01KnapsackBased;

//Problem: https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
//Video source: https://www.youtube.com/watch?v=-GtpxG6l_Mc&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=GS_OqZb2CWc&ab_channel=takeUforward
//TC: O(n*sum)
//SC: O(n*sum)

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 3};
//        int[] nums = {1, 2, 3};
        System.out.println(minDifference(nums));
    }

    static int minDifference(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;

        int n = arr.length;
        boolean[][] dp = callSubsetSum(arr, sum, n);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) { //Last row data
            if (dp[n][i]) {
                min = Math.min(min, Math.abs(sum - 2 * i));
            }
        }
        return min;
    }

    static boolean[][] callSubsetSum(int[] arr, int sum, int n) {
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
        return dp;
    }
}