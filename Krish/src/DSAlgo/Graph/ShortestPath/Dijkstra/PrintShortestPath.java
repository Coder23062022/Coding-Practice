package Krish.src.DSAlgo.Graph.ShortestPath.Dijkstra;

//Problem: https://takeuforward.org/plus/dsa/problems/print-shortest-path-
//Video source: https://www.youtube.com/watch?v=rp1SMw7HSO8&ab_channel=takeUforward
//Time complexity: O(m * logn)
//Space complexity: O(n)

import java.util.*;

public class PrintShortestPath {
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        for (int p : shortestPath(n, m, edges)) {
            System.out.print(p + " ");
        }
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static List<Integer> shortestPath(int n, int m, int[][] edges) {
        //Create adj list
        List<Pair>[] adj = new ArrayList[m];
        for (int i = 0; i < m; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a -> a.i));
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {
            int d = pq.peek().i;
            int node = pq.peek().j;
            pq.poll();

            for (Pair p : adj[node]) {
                int neighbor = p.i;
                int wt = p.j;

                if (d + wt < dist[neighbor]) {
                    dist[neighbor] = d + wt;
                    pq.add(new Pair(dist[neighbor], neighbor));
                    parent[neighbor] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
