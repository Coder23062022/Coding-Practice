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

        //Fill the first column with 1
        for (int i = 0; i < m; i++) {
            T[i][0] = 1;
        }

        //Fill the first row with 1
        for (int j = 0; j < n; j++) {
            T[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i - 1][j] + T[i][j - 1];
            }
        }

        return T[m - 1][n - 1];
    }
}