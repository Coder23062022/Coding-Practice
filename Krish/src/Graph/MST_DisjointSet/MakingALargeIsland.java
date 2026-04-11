package Krish.src.Graph.MST_DisjointSet;

//Problem: https://leetcode.com/problems/making-a-large-island/
//Video source: https://www.youtube.com/watch?v=lgiz0Oup6gM&ab_channel=takeUforward
//Time complexity: O(n^2)
//Space complexity: O(n^2)

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(largestIsland(grid));
    }

    static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet.DisjointUnionSets dus = new DisjointSet.DisjointUnionSets(n * n);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int adjRow = row + dr[k];
                        int adjCol = col + dc[k];
                        if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && grid[adjRow][adjCol] == 1) {
                            int nodeNo = row * n + col;
                            int adjNodeNo = adjRow * n + adjCol;
                            dus.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    Set<Integer> components = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int adjRow = row + dr[k];
                        int adjCol = col + dc[k];
                        if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && grid[adjRow][adjCol] == 1) {
                            int adjNodeNo = adjRow * n + adjCol;
                            components.add(dus.find(adjNodeNo));
                        }
                    }
                    int totalSize = 0;
                    for (int parent : components) totalSize += dus.size[parent];
                    max = Math.max(max, totalSize + 1);
                }
            }
        }

        for (int cellNo = 0; cellNo < n * n; cellNo++) max = Math.max(max, dus.size[dus.find(cellNo)]);
        return max;
    }
}
