package Krish.src.Graph;

//Problem: https://leetcode.com/problems/number-of-enclaves/
//Video source: https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15
//Time complexity: O(n*m), n and m are the number of rows and columns
//Space complexity: O(n*m)

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

    static int count = 0;

    static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        int noOfLands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                    count++;
                }

                if (grid[i][j] == 1) noOfLands++;
            }
        }

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            BFSUtil(grid, visited, row + 1, col, q);
            BFSUtil(grid, visited, row - 1, col, q);
            BFSUtil(grid, visited, row, col + 1, q);
            BFSUtil(grid, visited, row, col - 1, q);
        }

        return noOfLands > count ? (noOfLands - count) : 0;
    }

    static void BFSUtil(int[][] grid, int[][] visited, int r, int c, Queue<Pair> q) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 1 && visited[r][c] != 1) {
            q.add(new Pair(r, c));
            visited[r][c] = 1;
            count++;
        }
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