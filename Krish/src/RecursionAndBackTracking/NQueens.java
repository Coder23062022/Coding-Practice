package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Problem: https://leetcode.com/problems/n-queens/
//Video source: https://www.youtube.com/watch?v=BdSJnIdR-4s&ab_channel=ApnaCollege
//Time complexity: O(n!)
//Space complexity: O(n), recursion stack space

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> queen = solveNQueens(4);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i++;
        }
    }

    static boolean isSafe(char[][] board, int row, int col, int n) {
        //Column check
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        //Row check
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //Left diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //Right diagonal check
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static void nQueens(char[][] board, int row, int n, List<List<String>> ans) {
        //Base case
        if (row == n) {
            ans.add(construct(board));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1, n, ans); //Go row-wise
                board[row][j] = '.'; //Backtrack
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        nQueens(board, 0, n, ans);
        return ans;
    }
}