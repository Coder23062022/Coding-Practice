package Krish.src.Graph;

//Problem: https://leetcode.com/problems/shortest-bridge/
//Video source: https://www.youtube.com/watch?v=GSE0-dReL6Y&ab_channel=codestorywithMIK
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        System.out.println(shortestBridge(grid));
    }

    static int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        // 1. Find and mark the first island
        boolean found = false; //This is just to break from both the for loops when the first island is found
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited, queue);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        // 2. BFS to find shortest bridge
        return bfs(grid, queue, visited);
    }

    static void dfs(int[][] grid, int row, int col, boolean[][] visited, Queue<Pair> q) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0)
            return;
        visited[row][col] = true;
        q.offer(new Pair(row, col));
        dfs(grid, row + 1, col, visited, q);
        dfs(grid, row, col + 1, visited, q);
        dfs(grid, row - 1, col, visited, q);
        dfs(grid, row, col - 1, visited, q);
    }

    static int bfs(int[][] grid, Queue<Pair> queue, boolean[][] visited) {
        int levels = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; ++i) { //At every level of BFS, this loop will be executed and after this loop level will be increased by 1
                int r = queue.peek().row;
                int c = queue.peek().col;
                queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nRow = r + delRow[k];
                    int nCol = c + delCol[k];
                    if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && !visited[nRow][nCol]) {
                        if (grid[nRow][nCol] == 1)
                            return levels; //We found the 2nd island, so right now number of levels is the steps taken to reach from first island to the second one. So this is the answer.
                        visited[nRow][nCol] = true;
                        queue.offer(new Pair(nRow, nCol));
                    }
                }
            }
            levels++;
        }
        return -1;
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