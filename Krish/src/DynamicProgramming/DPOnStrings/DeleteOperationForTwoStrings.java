package Krish.src.DynamicProgramming.DPOnStrings;

//Problem: https://leetcode.com/problems/delete-operation-for-two-strings/
//Video source: https://www.youtube.com/watch?v=yMnH0jrir0Q&ab_channel=takeUforward
//Time complexity: O(m * n)
//Space complexity: O(m * n)

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }

    static int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lcsWithTabulation(word1, word2);
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