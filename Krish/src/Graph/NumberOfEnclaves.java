package Krish.src.Graph;

//Problem: https://leetcode.com/problems/number-of-enclaves/
//Video source: https://www.youtube.com/watch?v=rxKcepXQgU4&ab_channel=takeUforward
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(numEnclaves(grid));
    }

    static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            for (int k = 0; k < 4; k++) {
                int nRow = r + delRow[k];
                int nCol = c + delCol[k];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) count++;
            }
        }
        return count;
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}