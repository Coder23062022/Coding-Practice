package Krish.src.Graph.DFS;

//Problem: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
//https://leetcode.com/problems/number-of-distinct-islands/description/
//Video source: https://www.youtube.com/watch?v=7zmgQSJghpo&t=781s&ab_channel=takeUforward
//Time complexity: O(n * m)
//Space complexity: O(n * m)

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
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    List<String> list = new ArrayList<>();
                    dfs(grid, i, j, visited, i, j, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    static void dfs(int[][] grid, int r, int c, int[][] visited, int baseRow, int baseCol, List<String> list) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && visited[r][c] == 0) {
            visited[r][c] = 1;
            list.add(r - baseRow + " " + (c - baseCol));

            dfs(grid, r + 1, c, visited, baseRow, baseCol, list);
            dfs(grid, r - 1, c, visited, baseRow, baseCol, list);
            dfs(grid, r, c + 1, visited, baseRow, baseCol, list);
            dfs(grid, r, c - 1, visited, baseRow, baseCol, list);
        }
    }
}