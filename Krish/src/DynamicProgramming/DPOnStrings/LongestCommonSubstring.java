package Krish.src.DynamicProgramming.DPOnStrings;

//Problem: https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
//Video source: https://www.youtube.com/watch?v=_wP9mWNPL5w&ab_channel=takeUforward

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "abcdxyz";
        String str2 = "xyzabcd";
        System.out.println(lcsWithTabulation(str1, str2));
        System.out.println(lcsWithSpaceOptimization(str1, str2));
    }

    //TC: O(m * n), SC: O(m * n)
    static int lcsWithTabulation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }

    //TC: O(m * n), SC: O(2n)
    static int lcsWithSpaceOptimization(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    curr[j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    res = Math.max(res, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr.clone();
        }
        return res;
    }
}