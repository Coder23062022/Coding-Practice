package Krish.src.DynamicProgramming.DPOnStrings;

//Problem: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
//Video source: https://www.youtube.com/watch?v=xPBLEj41rFU&t=1s&ab_channel=takeUforward
//Time complexity: O(m * n)
//Space complexity: O(m * n)

public class MinimumInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {
//        String s = "zzazz";
        String s = "leetcode";
        System.out.println(minInsertions(s));
    }

    static int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }

    static int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();

        int m = s.length();
        int n = s1.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s.charAt(i - 1) == s1.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }
}