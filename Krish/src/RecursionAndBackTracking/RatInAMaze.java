package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
//Video source: https://www.youtube.com/watch?v=D8Yze9CDDAw&ab_channel=ApnaCollege
//Time complexity: O(4^(n^2)), Because n*n matrix and each cell has 4 choices
//Space complexity: O(n), recursion stack space

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        List<String> result = ratInMaze(maze);

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String p : result) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
            findPath(maze, n, 0, 0, "", res);
        }
        return res;
    }

    static void findPath(int[][] maze, int n, int row, int col, String path, ArrayList<String> res) {
        //Base case
        if (row == n - 1 && col == n - 1) {
            res.add(path);
            return;
        }

        if (row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0) {
            return;
        }

        maze[row][col] = 0;
        findPath(maze, n, row + 1, col, path + "D", res);
        findPath(maze, n, row, col - 1, path + "L", res);
        findPath(maze, n, row, col + 1, path + "R", res);
        findPath(maze, n, row - 1, col, path + "U", res);
        maze[row][col] = 1;
    }
}