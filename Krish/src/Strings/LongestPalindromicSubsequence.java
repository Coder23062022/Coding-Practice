package Strings;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //String str = "agbdba";
        String str = "5412ab332qwertyuiop145";
        System.out.println(lpsWithRecursion(str, 0, str.length() - 1));
        System.out.println(lpsWithDP(str, str.length()));
        System.out.println(lpsWithLCS(str, str.length()));
    }

    // By recursion
    static int lpsWithRecursion(String str, int i, int j) {
        // Base condition
        if (i > j) {
            return 0;
        }
        // If the string has only one character, it is a palindrome.
        if (i == j) {
            return 1;
        }
        if (str.charAt(i) == str.charAt(j)) {
            return 2 + lpsWithRecursion(str, i + 1, j - 1);
        } else {
            return Math.max(lpsWithRecursion(str, i + 1, j), lpsWithRecursion(str, i, j - 1));
        }
    }

    // By dynamic programming - video source: https://www.youtube.com/watch?v=_nCsPn7_OgI
    static int lpsWithDP(String str, int n) {
        int[][] T = new int[n][n];
        // Populating all the diagonal cells with 1
        for (int i = 0; i < n; i++) {
            T[i][i] = 1;
        }
        // Filling the memoization table in bottom-up manner.
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    T[i][j] = 2 + T[i + 1][j - 1];
                } else {
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][n - 1];
    }

    //Longest palindromic subsequence(LPS) of a string is nothing but the longest common subsequence(LCS) of that string
    //and it's reverse string.
    static int lpsWithLCS(String str, int n) {
        int[][] T = new int[n + 1][n + 1];
        String strRev = new StringBuilder(str).reverse().toString();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    T[i][j] = 0;
                else if (str.charAt(i - 1) == strRev.charAt(j - 1))
                    T[i][j] = 1 + T[i - 1][j - 1];
                else
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
            }
        }
        /*Print the matrix
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }*/
        return T[n][n];
    }
}