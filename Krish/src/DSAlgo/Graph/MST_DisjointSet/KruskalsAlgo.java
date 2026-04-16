package Krish.src.DSAlgo.Graph.MST_DisjointSet;

//Problem: https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1
//Video source: https://www.youtube.com/watch?v=DMnDM_sxVig&t=1s&ab_channel=takeUforward
//Time complexity: O(E * logE) or O(E * logV), sorting takes ElogE time
//Space complexity: O(V)

import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgo {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 10}, {1, 3, 15}, {2, 3, 4}, {2, 0, 6}, {0, 3, 5}}; //{u, v, w}
        System.out.println(kruskalsMST(4, edges));
    }

    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2])); //Sort all the edges based on weight
        DisjointSet.DisjointUnionSets dus = new DisjointSet.DisjointUnionSets(V);

        int cost = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            //Make sure that there is no cycle
            if (dus.find(u) != dus.find(v)) {
                dus.unionBySize(u, v);
                cost += w;
            }
        }
        return cost;
    }
}