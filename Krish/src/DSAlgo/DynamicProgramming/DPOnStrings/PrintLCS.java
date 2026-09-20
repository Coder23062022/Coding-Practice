package Krish.src.DSAlgo.DynamicProgramming.DPOnStrings;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/dsa/printing-longest-common-subsequence/
//Video source: https://www.youtube.com/watch?v=-zI4mrF2Pb4&ab_channel=takeUforward
//Time complexity: O(m * n) + O(m + n)
//Space complexity: O(m * n)

public class PrintLCS {
    static void main() {
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

        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                res[index] = String.valueOf(str1.charAt(m - 1));
                index--;
                m--;
                n--;
            } else if (dp[m - 1][n] > dp[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }
        return Arrays.toString(res);
    }
}