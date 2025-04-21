package Krish.src.Graph;

//Problem: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
//https://leetcode.com/problems/number-of-distinct-islands/description/
//Video source: https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=16
//Time complexity: O(n*m)
//Space complexity: O(n*m)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Number of Islands are: " + countDistinctIslands(grid));
    }

    static int countDistinctIslands(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Set<List<String>> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    List<String> list = new ArrayList<>();
                    DFSUtil(grid, i, j, visited, i, j, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    static void DFSUtil(int[][] grid, int r, int c, int[][] visited, int baseRow, int baseCol, List<String> list) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 1 && visited[r][c] != 1) {
            visited[r][c] = 1;
            list.add(r - baseRow + " " + (c - baseCol));

            DFSUtil(grid, r + 1, c, visited, baseRow, baseCol, list);
            DFSUtil(grid, r - 1, c, visited, baseRow, baseCol, list);
            DFSUtil(grid, r, c + 1, visited, baseRow, baseCol, list);
            DFSUtil(grid, r, c - 1, visited, baseRow, baseCol, list);
        }
    }
}