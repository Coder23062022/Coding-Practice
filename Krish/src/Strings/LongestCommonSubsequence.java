package Strings;

//Time Complexity of this implementation is: O(mn)
//Video reference: https://www.youtube.com/watch?v=NnD96abizww

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(lcsWithRecursion(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsWithDP(str1, str2, str1.length(), str2.length()));
    }

    static int lcsWithRecursion(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return 1 + lcsWithRecursion(str1, str2, m - 1, n - 1);
        else
            return Math.max(lcsWithRecursion(str1, str2, m, n - 1), lcsWithRecursion(str1, str2, m - 1, n));
    }

    static int lcsWithDP(String str1, String str2, int m, int n) {
        int[][] T = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    T[i][j] = 0;
                    //If both the characters are same then add 1 with the diagonal value of the matrix. Otherwise, take the maximum
                    //value of [i][j - 1] and [i - 1][j] position. For better understanding check the video source mentioned at the top.
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    T[i][j] = T[i - 1][j - 1] + 1;
                else
                    T[i][j] = Math.max(T[i][j - 1], T[i - 1][j]);
            }
        }
        return T[m][n];
    }
}