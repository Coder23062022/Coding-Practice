package Krish.src.DynamicProgramming.DPOnStrings;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/edit-distance/
//Video source: https://www.youtube.com/watch?v=fJaKO8FbDdo&ab_channel=takeUforward

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistanceWithRecursion(word1, word2));
        System.out.println(minDistanceWithMemoization(word1, word2));
        System.out.println(minDistanceWithTabulation(word1, word2));
        System.out.println(minDistanceWithSpaceOptimization(word1, word2));
    }

    //TC: O(3^(m + n)), SC: O(m * n)
    static int minDistanceWithRecursion(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return recursionHelper(word1, word2, m, n);
    }

    static int recursionHelper(String word1, String word2, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return recursionHelper(word1, word2, i - 1, j - 1);
        } else {
            return Math.min(1 + recursionHelper(word1, word2, i, j - 1),
                    Math.min(1 + recursionHelper(word1, word2, i - 1, j),
                            1 + recursionHelper(word1, word2, i - 1, j - 1)));
        }
    }

    //TC: O(m * n), SC: O(m * n) + O(m + n)
    static int minDistanceWithMemoization(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memoizationHelper(word1, word2, m, n, dp);
    }

    static int memoizationHelper(String word1, String word2, int i, int j, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return memoizationHelper(word1, word2, i - 1, j - 1, dp);
        } else {
            return Math.min(1 + memoizationHelper(word1, word2, i, j - 1, dp),
                    Math.min(1 + memoizationHelper(word1, word2, i - 1, j, dp),
                            1 + memoizationHelper(word1, word2, i - 1, j - 1, dp)));
        }
    }

    //TC: O(m * n), SC: O(m * n)
    static int minDistanceWithTabulation(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 0; i <= m; i++) dp[i][0] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - 1], Math.min(1 + dp[i - 1][j], 1 + dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    //TC: O(m * n), SC: O(m + n)
    static int minDistanceWithSpaceOptimization(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++) prev[j] = j;

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = Math.min(1 + curr[j - 1],
                            Math.min(1 + prev[j],
                                    1 + prev[j - 1]));
                }
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}