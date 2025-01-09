package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/unique-paths/
//Video source: https://www.youtube.com/watch?v=IlEsdxuD4lY&ab_channel=NeetCode
//Time complexity: O(m * n)
//Space complexity: O(n)

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }

    static int uniquePaths(int m, int n) {
        int[][] T = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 1;
                } else {
                    T[i][j] = T[i - 1][j] + T[i][j - 1];
                }
            }
        }
        return T[m - 1][n - 1];
    }
}