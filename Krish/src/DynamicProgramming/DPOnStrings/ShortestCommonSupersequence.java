package Krish.src.DynamicProgramming.DPOnStrings;

//Problem: https://leetcode.com/problems/shortest-common-supersequence/
//Video source: https://www.youtube.com/watch?v=xElxAuBcvsU&ab_channel=takeUforward
//Time complexity: O(m * n)
//Space complexity: O(m * n)

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
//        String str1 = "brute", str2 = "groot";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }

    static String shortestCommonSupersequence(String str1, String str2) {
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

        int lcsLen = dp[m][n];
        int scsLen = m + n - lcsLen; //This is not in use for this problem, but just to know the length of scs

        StringBuilder res = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res.append(str1.charAt(i - 1));
                i--;
            } else {
                res.append(str2.charAt(j - 1));
                j--;
            }
        }

        //For leftover characters in the first string
        while (i > 0) {
            res.append(str1.charAt(i - 1));
            i--;
        }

        //For leftover characters in the second string
        while (j > 0) {
            res.append(str2.charAt(j - 1));
            j--;
        }

        //Reverse the string as we formed the result in bottom-up approach
        return res.reverse().toString();
    }
}