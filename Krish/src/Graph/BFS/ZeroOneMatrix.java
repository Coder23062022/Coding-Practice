package Krish.src.Graph.BFS;

//Problem: https://leetcode.com/problems/01-matrix/
//Video source: https://www.youtube.com/watch?v=edXdVwkYHF8&t=517s&ab_channel=takeUforward
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 0, 1}};
        for (int[] row : updateMatrix(mat)) System.out.println(Arrays.toString(row));
    }

    static int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dist = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<Triplet> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Triplet(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int d = q.peek().dist;
            q.poll();

            dist[r][c] = d;

            for (int k = 0; k < 4; k++) {
                int nRow = r + delRow[k];
                int nCol = c + delCol[k];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    q.add(new Triplet(nRow, nCol, d + 1));
                }
            }
        }
        return dist;
    }

    static class Triplet {
        int row, col, dist;

        Triplet(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}