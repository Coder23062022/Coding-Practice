package Krish.src.Graph.BFS;

//Problem: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//Video source: https://www.youtube.com/watch?v=BPlrALf1LDU&ab_channel=takeUforward
//Time complexity: O(V + 2E)
//Space complexity: O(V)

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class CycleDetectionInUndirectedGraphBFS {
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
                if (bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }

    static boolean bfs(int start, List<Integer>[] adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parentNode = q.peek().parentNode;
            q.poll();

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new Pair(neighbor, node));
                }
                //If visited and not the parent, cycle exists
                else if (neighbor != parentNode) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {
        int node, parentNode;

        Pair(int node, int parentNode) {
            this.node = node;
            this.parentNode = parentNode;
        }
    }
}