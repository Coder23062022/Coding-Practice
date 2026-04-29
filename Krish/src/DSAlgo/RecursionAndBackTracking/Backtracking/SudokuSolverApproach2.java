package Krish.src.DSAlgo.RecursionAndBackTracking.Backtracking;

//Problem: https://leetcode.com/problems/sudoku-solver/
//Video source: https://www.youtube.com/watch?v=FWAIf_EVUKE
//Time complexity: O(9^n), n = number of empty cells (Because each cell has 9 choices)
//Space complexity: O(n), recursion stack space

public class SudokuSolverApproach2 {
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

    static void solveSudoku(char[][] board) {
        helper(board);
    }

    static boolean helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isSafe(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (helper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false; //You can't place anything in that cell
                }
            }
        }
        return true; //This means all cells are filled up and sudoku is solved
    }

    static boolean isSafe(char[][] board, int row, int col, int digit) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) return false;
            if (board[row][i] == digit) return false;
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == digit) return false;
        }
        return true;
    }
}