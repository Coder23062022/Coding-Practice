package Krish.src.DSAlgo.Graph.MST_DisjointSet;

//Problem: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
//Video source: https://www.youtube.com/watch?v=FYrl7iz9_ZU&ab_channel=takeUforward
//Time complexity: O((E + n) * 4alpha)
//Space complexity: O(n)

public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(makeConnected(n, connections));
    }

    static int makeConnected(int n, int[][] connections) {
        DisjointSet.DisjointUnionSets dus = new DisjointSet.DisjointUnionSets(n);
        int extraEdges = 0;
        for (int[] e : connections) {
            int u = e[0], v = e[1];

            if (dus.find(u) == dus.find(v)) {
                extraEdges++;
            } else {
                dus.unionBySize(u, v);
            }
        }

        int cnC = 0;
        for (int i = 0; i < n; i++) if (dus.parent[i] == i) cnC++;

        int ans = cnC - 1;
        return extraEdges >= ans ? ans : -1;
    }
}