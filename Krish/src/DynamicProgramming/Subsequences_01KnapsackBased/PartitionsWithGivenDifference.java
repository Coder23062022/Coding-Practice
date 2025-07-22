package Krish.src.DynamicProgramming.Subsequences_01KnapsackBased;

//Problem: https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
//Video source: https://www.youtube.com/watch?v=ot_XBHyqpFc&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=zoilQD1kYSg&ab_channel=takeUforward
//TC: O(n*sum)
//SC: O(n*sum)

public class PartitionsWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int d = 3;
        System.out.println(countPartitions(arr, d));
    }

    static int countPartitions(int[] arr, int d) {
        int sum = 0;
        for (int num : arr) sum += num;
        if ((sum + d) % 2 != 0) return 0;
        int sum1 = (sum + d) / 2;
        return callCountOfSubsetSum(arr, sum1);
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