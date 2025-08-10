package Krish.src.Graph.TopoSort;

//Problem: https://www.geeksforgeeks.org/problems/topological-sort/1
//Video source: https://www.youtube.com/watch?v=5lZ0iJMrUMk&ab_channel=takeUforward
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortUsingDFS {
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

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    static void dfs(int node, List<Integer>[] adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}