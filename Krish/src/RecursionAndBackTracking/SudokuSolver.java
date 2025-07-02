package Krish.src.RecursionAndBackTracking;

//Problem: https://leetcode.com/problems/sudoku-solver/
//Video source: https://www.youtube.com/watch?v=70cP3qtJp-s&t=27s&ab_channel=ApnaCollege
//Time complexity: O(9^n), n = number of empty cells (Because each cell has 9 choices)
//Space complexity: O(n), recursion stack space

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] mat = {
                {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
                {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
                {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
                {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
                {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
                {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
                {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };

        solveSudoku(mat);

        //Print the matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(char[][] board, int row, int col, int digit) {
        //Column check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        //Row check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        //Grid check
        int srow = (row / 3) * 3;
        int scol = (col / 3) * 3;
        for (int i = srow; i <= srow + 2; i++) {
            for (int j = scol; j <= scol + 2; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean helper(char[][] board, int row, int col) {
        //Base case
        if (row == 9) return true;

        //Go row-wise
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return helper(board, nextRow, nextCol);
        }

        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (helper(board, nextRow, nextCol)) return true;
                board[row][col] = '.'; //Backtrack
            }
        }

        return false;
    }

    static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}