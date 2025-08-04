package Krish.src.DynamicProgramming.PartitionDP;

//Problem: https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
//Video source: https://www.youtube.com/watch?v=kMK148J9qEE&t=1184s&ab_channel=AdityaVerma
//Video source: https://www.youtube.com/watch?v=vRVfmbCFW7Y&t=1478s&ab_channel=takeUforward

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};
        System.out.println(matrixMultiplicationWithRecursion(arr));
        System.out.println(matrixMultiplicationWithMemoization(arr));
        System.out.println(matrixMultiplicationWithTabulation(arr));
    }

    //TC: O(2^n), SC: O(n)
    static int matrixMultiplicationWithRecursion(int[] arr) {
        int n = arr.length;
        return matrixMultiplicationHelperWithRecursion(arr, 1, n - 1);
    }

    static int matrixMultiplicationHelperWithRecursion(int[] arr, int i, int j) {
        if (i >= j) return 0;

        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int curr = matrixMultiplicationHelperWithRecursion(arr, i, k)
                    + matrixMultiplicationHelperWithRecursion(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];
            res = Math.min(curr, res);
        }
        return res;
    }

    //TC: O(n*n*n), SC: O(n*n) + O(n)
    static int matrixMultiplicationWithMemoization(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return matrixMultiplicationHelperWithMemoization(arr, 1, n - 1, dp);
    }

    static int matrixMultiplicationHelperWithMemoization(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int curr = matrixMultiplicationHelperWithMemoization(arr, i, k, dp)
                    + matrixMultiplicationHelperWithMemoization(arr, k + 1, j, dp)
                    + arr[i - 1] * arr[k] * arr[j];
            res = Math.min(curr, res);
        }
        return dp[i][j] = res;
    }

    //TC: O(n*n*n), SC: O(n*n)
    static int matrixMultiplicationWithTabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) dp[i][i] = 0; //Base case

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int res = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int curr = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    res = Math.min(curr, res);
                }
                dp[i][j] = res;
            }
        }
        return dp[1][n - 1];
    }
}