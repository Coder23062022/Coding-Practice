package Krish.src.Graph.DFS;

//Problem: https://www.geeksforgeeks.org/problems/bipartite-graph/1
//Problem: https://leetcode.com/problems/is-graph-bipartite/
//Video source: https://www.youtube.com/watch?v=KG5YFfR0j8A&ab_channel=takeUforward
//Time complexity: O(V + 2E)
//Space complexity: O(V)

import java.util.*;

public class BipartiteGraphUsingDFS {
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0, 1}, {1, 2}};
        System.out.println(isBipartite(V, edges));
    }

    static boolean isBipartite(int V, int[][] edges) {
        //Create adj list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, adj, colors)) return false;
            }
        }
        return true;
    }

    static boolean dfs(int node, int color, List<Integer>[] adj, int[] colors) {
        colors[node] = color;
        for (int neighbor : adj[node]) {
            if (colors[neighbor] == -1) {
                if (!dfs(neighbor, 1 - color, adj, colors)) return false;
            } else if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }
}
