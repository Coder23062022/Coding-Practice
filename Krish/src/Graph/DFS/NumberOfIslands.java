package Krish.src.Graph.DFS;

//Problem: https://leetcode.com/problems/number-of-islands/
//Video source: https://www.youtube.com/watch?v=muncqlKJrH0&t=483s&ab_channel=takeUforward
//Time complexity: O(n^2)
//Space complexity: O(n^2)

public class NumberOfIslands {
    static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length; //Number of rows
        int m = grid[0].length; // Number of columns
        int[][] visited = new int[n][m]; //Visited array to track the visited nodes
        int noOfIslands = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1' && visited[i][j] == 0) { //Found an island which is not visited
                    noOfIslands += 1;
                    DFSUtil(grid, i, j, visited);
                }
        return noOfIslands;
    }

    static void DFSUtil(char[][] grid, int row, int col, int[][] visited) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' && visited[row][col] == 0) {
            visited[row][col] = 1;
            DFSUtil(grid, row + 1, col, visited);
            DFSUtil(grid, row, col + 1, visited);
            DFSUtil(grid, row - 1, col, visited);
            DFSUtil(grid, row, col - 1, visited);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of Islands are: " + numIslands(grid));
    }
}