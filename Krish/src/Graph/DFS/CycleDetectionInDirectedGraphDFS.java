package Krish.src.Graph.DFS;

//Problem: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
//Video source: https://www.youtube.com/watch?v=9twcmtQj4DU&ab_channel=takeUforward
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraphDFS {
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

        int[] visited = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited, pathVisited)) return true;
            }
        }
        return false;
    }

    static boolean dfs(int node, List<Integer>[] adj, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int neighbor : adj[node]) {
            if (visited[neighbor] == 0) {
                if (dfs(neighbor, adj, visited, pathVisited)) return true;
            } else if (pathVisited[neighbor] == 1) {
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }
}