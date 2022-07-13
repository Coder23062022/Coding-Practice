package src.Graph;

//Problem: https://leetcode.com/problems/number-of-islands/

public class NumberOfIslandsLeetCodeSolve {
    static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == '1') { //Found an island.
                    noOfIslands += 1;
                    DFSUtil(grid, i, j);
                }
        return noOfIslands;
    }

    static void DFSUtil(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '#'; //Disappear this cell. You can put 0 or any character here except 1.
        DFSUtil(grid, row + 1, col);
        DFSUtil(grid, row - 1, col);
        DFSUtil(grid, row, col + 1);
        DFSUtil(grid, row, col - 1);
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
