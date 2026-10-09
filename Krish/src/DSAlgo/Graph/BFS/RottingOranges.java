package Krish.src.DSAlgo.Graph.BFS;

//Problem: https://leetcode.com/problems/rotting-oranges/
//Video source: https://www.youtube.com/watch?v=yf3oUhkvqA0&ab_channel=takeUforward
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    static void main() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }

    static int count = 0; //This count is to track how many fresh oranges are getting rotten

    static int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Triplet> q = new LinkedList<>();
        int freshOrangesCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Triplet(i, j, 0));
                    visited[i][j] = 1;
                } else if (grid[i][j] == 1) {
                    freshOrangesCount++;
                }
            }
        }

        int time = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(time, t);
            q.remove();

            for (int k = 0; k < 4; k++) {
                int nRow = r + delRow[k];
                int nCol = c + delCol[k];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    q.add(new Triplet(nRow, nCol, t + 1));
                    count++;
                }
            }
        }
        return freshOrangesCount == count ? time : -1;
    }

    static class Triplet {
        int row;
        int col;
        int time;

        Triplet(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}