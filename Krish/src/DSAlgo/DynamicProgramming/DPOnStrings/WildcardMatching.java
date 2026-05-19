package Krish.src.DSAlgo.DynamicProgramming.DPOnStrings;

//Problem: https://leetcode.com/problems/wildcard-matching/
//Video source: https://www.youtube.com/watch?v=ZmlQ3vgAOMo&ab_channel=takeUforward

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "aa", p = "*";
        System.out.println(isMatchWithRecursion(s, p));
        System.out.println(isMatchWithMemoization(s, p));
        System.out.println(isMatchWithTabulation(s, p));
    }

    //TC: O(2^(m + n)), SC: O(m + n)
    static boolean isMatchWithRecursion(String s, String p) {
        int m = s.length();
        int n = p.length();
        return recursionHelper(s, p, m, n);
    }

    static boolean recursionHelper(String text, String pattern, int m, int n) {
        //Empty pattern can match with an empty text only
        if (n == 0) return m == 0;

        //Empty text can match with a pattern consisting of '*' only.
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                if (pattern.charAt(i) != '*') return false;
            }
            return true;
        }

        if (text.charAt(m - 1) == pattern.charAt(n - 1) || pattern.charAt(n - 1) == '?') {
            return recursionHelper(text, pattern, m - 1, n - 1);
        }

        if (pattern.charAt(n - 1) == '*') {
            return recursionHelper(text, pattern, m, n - 1) || recursionHelper(text, pattern, m - 1, n);
        }
        return false;
    }

    //TC: O(m * n), SC: O(m * n) + O(m + n)
    static boolean isMatchWithMemoization(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        return memoizationHelper(s, p, m, n, dp);
    }

    static boolean memoizationHelper(String text, String pattern, int m, int n, boolean[][] dp) {
        if (n == 0) return m == 0;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                if (pattern.charAt(i) != '*') return false;
            }
            return true;
        }

        if (dp[m][n]) return dp[m][n];

        if (text.charAt(m - 1) == pattern.charAt(n - 1) || pattern.charAt(n - 1) == '?') {
            dp[m][n] = memoizationHelper(text, pattern, m - 1, n - 1, dp);
        }

        if (pattern.charAt(n - 1) == '*') {
            dp[m][n] = memoizationHelper(text, pattern, m, n - 1, dp) || memoizationHelper(text, pattern, m - 1, n, dp);
        }

        return dp[m][n];
    }

    //TC: O(m * n), SC: O(m * n)
    static boolean isMatchWithTabulation(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        //Empty pattern matches with empty string
        dp[0][0] = true;

        //Handle patterns with '*' at the beginning
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        //You can also write the case of s.length() = 0 as:
//        for (int j = 1; j <= m; j++) {
//            boolean flag = true;
//            for (int i = 1; i <= j; i++) {
//                if (p.charAt(i - 1) != '*') {
//                    flag = false;
//                    break;
//                }
//            }
//            dp[0][j] = flag;
//        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}