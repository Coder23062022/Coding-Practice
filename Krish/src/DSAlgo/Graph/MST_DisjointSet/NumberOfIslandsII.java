package Krish.src.DSAlgo.Graph.MST_DisjointSet;

//Problem: https://www.geeksforgeeks.org/problems/number-of-islands/1
//Video source: https://www.youtube.com/watch?v=Rn6B-Q4SNyA&ab_channel=takeUforward
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    public static void main(String[] args) {
        int n = 4, m = 5, k = 4;
        int[][] A = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};
        System.out.println(numOfIslands(n, m, A));
    }

    static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int n = rows, m = cols;
        DisjointSet.DisjointUnionSets dus = new DisjointSet.DisjointUnionSets(n * m);
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        List<Integer> res = new ArrayList<>();

        for (int[] operator : operators) {
            int row = operator[0];
            int col = operator[1];
            if (visited[row][col]) {
                res.add(count);
                continue;
            }
            visited[row][col] = true;
            count++;

            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int adjRow = row + dr[k];
                int adjCol = col + dc[k];

                if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m && visited[adjRow][adjCol]) {
                    int nodeNo = row * m + col;
                    int adjNodeNo = adjRow * m + adjCol;

                    if (dus.find(nodeNo) != dus.find(adjNodeNo)) {
                        count--;
                        dus.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
}