package Krish.src.DSAlgo.Graph.ShortestPath.Dijkstra;

//Problem: https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1
//Video source: https://www.youtube.com/watch?v=U5Mw4eyUmw4&ab_channel=takeUforward
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInABinaryMaze {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int[] source = {0, 1};
        int[] destination = {2, 2};
        System.out.println(shortestPath(grid, source, destination));
    }

    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Triplet {
        int dist;
        Pair pair;

        Triplet(int dist, Pair pair) {
            this.dist = dist;
            this.pair = pair;
        }
    }

    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) return 0;

        int n = grid.length, m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, (int) 1e9);
        dist[source[0]][source[1]] = 0;

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, new Pair(source[0], source[1])));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int d = q.peek().dist;
            int r = q.peek().pair.row;
            int c = q.peek().pair.col;
            q.poll();

            for (int k = 0; k < 4; k++) {
                int nRow = r + dr[k];
                int nCol = c + dc[k];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && d + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = d + 1;
                    if (nRow == destination[0] && nCol == destination[1]) return dist[nRow][nCol];
                    q.add(new Triplet(dist[nRow][nCol], new Pair(nRow, nCol)));
                }
            }
        }
        return -1;
    }
}