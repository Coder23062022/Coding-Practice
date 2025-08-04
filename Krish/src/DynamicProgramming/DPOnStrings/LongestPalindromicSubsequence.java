package Krish.src.DynamicProgramming.DPOnStrings;

//Problem: https://leetcode.com/problems/longest-palindromic-subsequence/
//Video source: https://www.youtube.com/watch?v=6i_T5kkfv4A&ab_channel=takeUforward
//Time complexity: O(m * n)
//Space complexity: O(m * n)

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    static int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        return lcsWithTabulation(s, s1);
    }

    static int lcsWithTabulation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }
}