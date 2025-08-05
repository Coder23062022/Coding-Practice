package Krish.src.Graph;

//Problem: https://leetcode.com/problems/surrounded-regions/
//Video source: https://www.youtube.com/watch?v=BtdgAys4yMk&ab_channel=takeUforward
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        char[][] board = {{'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'}, {'X', 'O', 'O', 'X'}, {'O', 'O', 'X', 'X'}};
        for (char[] row : solve(board)) System.out.println(Arrays.toString(row));
    }

    static char[][] solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            //First row
            if (!visited[0][j] && board[0][j] == 'O') {
                dfs(board, 0, j, visited);
            }

            //Last row
            if (!visited[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(board, n - 1, j, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            //First col
            if (!visited[i][0] && board[i][0] == 'O') {
                dfs(board, i, 0, visited);
            }

            //Last col
            if (!visited[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(board, i, m - 1, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

    static void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'O' && !visited[row][col]) {
            visited[row][col] = true;
            dfs(board, row + 1, col, visited);
            dfs(board, row, col + 1, visited);
            dfs(board, row - 1, col, visited);
            dfs(board, row, col - 1, visited);
        }
    }
}