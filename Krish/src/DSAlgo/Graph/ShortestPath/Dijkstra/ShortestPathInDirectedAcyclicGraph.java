package Krish.src.DSAlgo.Graph.ShortestPath.Dijkstra;

//Problem: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
//Video source: https://www.youtube.com/watch?v=ZUFQfFaU-8U&t=949s&ab_channel=takeUforward
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {
        int V = 4, E = 2;
        int[][] edges = {{0, 1, 2}, {0, 2, 1}};
        System.out.println(Arrays.toString(shortestPath(V, E, edges)));
    }

    static class Pair {
        int vertex;
        int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static int[] shortestPath(int V, int E, int[][] edges) {
        //Create adj list
        List<Pair>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            adj[u].add(new Pair(v, w));
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (Pair p : adj[node]) {
                int v = p.vertex;
                int wt = p.weight;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }

    static void dfs(int node, List<Pair>[] adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (Pair p : adj[node]) {
            int v = p.vertex;
            if (!visited[v]) {
                dfs(v, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}