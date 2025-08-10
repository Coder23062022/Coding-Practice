package Krish.src.Graph.TopoSort;

//Problem: https://www.geeksforgeeks.org/problems/topological-sort/1
//Video source: https://www.youtube.com/watch?v=73sneFXuTEg&t=20s&ab_channel=takeUforward
//Known as: Kahn's Algorithm
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.*;

public class TopologicalSortUsingBFS_KahnsAlgo {
    public static void main(String[] args) {
        int V = 4, E = 3;
        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(V, edges));
    }

    static ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        return res;
    }
}