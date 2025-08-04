package Krish.src.DynamicProgramming.DPOnStrings;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/dsa/printing-longest-common-subsequence/
//Video source: https://www.youtube.com/watch?v=-zI4mrF2Pb4&ab_channel=takeUforward
//Time complexity: O(m * n) + O(m + n)
//Space complexity: O(m * n)

public class PrintLCS {
    public static void main(String[] args) {
//        String str1 = "AGGTAB";
//        String str2 = "GXTXAYB";
        String str1 = "aed";
        String str2 = "acd";
        System.out.println(printLcs(str1, str2));
    }

    static String printLcs(String str1, String str2) {
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
        String[] res = new String[lcsLen];
        Arrays.fill(res, "$");

        int index = lcsLen - 1;
        int i = str1.length(), j = str2.length();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res[index] = String.valueOf(str1.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return Arrays.toString(res);
    }
}