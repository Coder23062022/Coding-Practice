package Krish.src.Graph.ShortestPath.Dijkstra;

//Problem: https://leetcode.com/problems/path-with-minimum-effort
//Video source: https://www.youtube.com/watch?v=0ytpZyiZFhA&t=1010s&ab_channel=takeUforward
//Time complexity: O(E * logV)
//Space complexity: O(V)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));
    }

    static class Triplet {
        int diff, row, col;

        Triplet(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }

    static int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, (int) 1e9);
        dist[0][0] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>(Comparator.comparing(a -> a.diff));
        pq.add(new Triplet(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            int diff = pq.peek().diff;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.poll();

            if (r == n - 1 && c == m - 1) return diff;

            for (int k = 0; k < 4; k++) {
                int nRow = r + dr[k];
                int nCol = c + dc[k];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int maxDiff = Math.max(diff, Math.abs(heights[nRow][nCol] - heights[r][c]));
                    if (maxDiff < dist[nRow][nCol]) {
                        dist[nRow][nCol] = maxDiff;
                        pq.add(new Triplet(maxDiff, nRow, nCol));
                    }
                }
            }
        }
        return -1;
    }
}