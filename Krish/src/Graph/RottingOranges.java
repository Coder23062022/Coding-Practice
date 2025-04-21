package Krish.src.Graph;

//Problem: https://leetcode.com/problems/rotting-oranges/
//Video source: https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=11
//Time complexity: O(n*m), n and m are the number of rows and columns
//Space complexity: O(n*m)

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }

    static int count = 0; //This count is to track how many fresh oranges are getting rotten

    static int orangesRotting(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int freshOrangesCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                } else if (grid[i][j] == 1) {
                    freshOrangesCount++;
                }
            }
        }

        int result = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.remove();

            BFSUtil(grid, r + 1, c, visited, t, q);
            BFSUtil(grid, r - 1, c, visited, t, q);
            BFSUtil(grid, r, c + 1, visited, t, q);
            BFSUtil(grid, r, c - 1, visited, t, q);
            result = t;
        }
        return freshOrangesCount == count ? result : -1;
    }

    static void BFSUtil(int[][] grid, int row, int col, int[][] visited, int t, Queue<Pair> q) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1 && visited[row][col] != 1) {
            grid[row][col] = 2;
            visited[row][col] = 1;
            q.add(new Pair(row, col, t + 1));
            count++;
        }
    }

    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}