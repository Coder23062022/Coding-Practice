package Krish.src.Graph.TopoSort;

//Problem: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
//Video source: https://www.youtube.com/watch?v=iTBaI90lpDQ&ab_channel=takeUforward
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.*;

public class CycleDetectionInDirectedGraphBFS {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println(isCyclic(V, edges));
    }

    static boolean isCyclic(int V, int[][] edges) {
        //Create adj list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
        }

        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int vertex : adj[i]) {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int neighbor : adj[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return res.size() != V;
    }
}