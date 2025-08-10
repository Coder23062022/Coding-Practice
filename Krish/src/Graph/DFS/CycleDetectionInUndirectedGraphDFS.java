package Krish.src.Graph.DFS;

//Problem: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//Video source: https://www.youtube.com/watch?v=zQ3zgFypzX4&ab_channel=takeUforward
//Time complexity: O(V + 2E)
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInUndirectedGraphDFS {
    public static void main(String[] args) {
        int V = 4, E = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(isCycle(V, edges));
    }

    static boolean isCycle(int V, int[][] edges) {
        //Create adj list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, -1)) return true;
            }
        }
        return false;
    }

    static boolean dfs(int v, List<Integer>[] adj, boolean[] visited, int parent) {
        visited[v] = true;
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                if (!dfs(neighbor, adj, visited, v)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}