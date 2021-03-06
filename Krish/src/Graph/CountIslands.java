package src.Graph;

public class CountIslands {
    static final int ROW = 5, COL = 5;

    // These arrays are used to get row and column numbers of 8 neighbors of a given cell.
    static int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};

    // The main function that returns count of islands in a given boolean 2D matrix.
    static int countIslands(int[][] grid) {
        // Make a bool array to mark visited cells. Initially all cells are unvisited.
        boolean[][] visited = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through the all cells of given matrix.
        int noOfIslands = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                // If a cell with value 1 is not visited yet, then new island found. Visit all cells on this island and increment island count.
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ++noOfIslands;
                    DFSUtil(grid, i, j, visited);
                }
        return noOfIslands;
    }

    // A utility function to do DFS for a 2D boolean matrix. It only considers the 8 neighbors as adjacent vertices.
    static void DFSUtil(int[][] grid, int row, int col, boolean[][] visited) {
        // Mark this cell as visited.
        visited[row][col] = true;

        // Recur for all connected neighbours.
        for (int k = 0; k < 8; ++k) {
            int newRow = row + rowNbr[k];
            int newCol = col + colNbr[k];
            if (newRow >= 0 && newRow < ROW && newCol >= 0 && newCol < COL && grid[newRow][newCol] == 1 && !visited[newRow][newCol])
                DFSUtil(grid, newRow, newCol, visited);
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands is: " + countIslands(grid));
    }
}
