package Krish.src.DSAlgo.Graph.MST_DisjointSet;

//Problem: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
//Video source: https://www.youtube.com/watch?v=OwMNX8SPavM&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
//        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int[][] stones = {{0, 0}, {0, 2}, {1, 3}, {3, 0}, {3, 2}, {4, 3}};
        System.out.println(removeStones(stones));
    }

    static int removeStones(int[][] stones) {
        //Here only stone positions are given, so we have to first find the dimension of the grid
        int noOfRows = 0, noOfCols = 0;
        for (int[] stone : stones) {
            noOfRows = Math.max(noOfRows, stone[0]);
            noOfCols = Math.max(noOfCols, stone[1]);
        }

        //As it's 0-based indexing, so we have to add +1 with noOfRows and noOfCols to find the actual dimension (n*m grid)
        int n = noOfRows + 1, m = noOfCols + 1;
        DisjointSet.DisjointUnionSets dus = new DisjointSet.DisjointUnionSets(n + m);

        Set<Integer> totalNodes = new HashSet<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + n;
            dus.unionBySize(row, col);
            totalNodes.add(row);
            totalNodes.add(col);
        }

        int componentCount = 0;
        for (int node : totalNodes) {
            //number of ultimate parents = number of components,
            //so if any node is the parent of itself then increase the component count
            if (dus.find(node) == node) componentCount++;
        }
        return stones.length - componentCount;
    }
}