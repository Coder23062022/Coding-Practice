package Krish.src.Graph.ShortestPath.Dijkstra;

//Problem: https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
//Video source: https://www.youtube.com/watch?v=V6H1qAeB-l4&t=866s&ab_channel=takeUforward
//Time complexity: O(E * logV)
//Space complexity: O(V)

import java.util.*;

public class DijkstrasAlgorithmUsingPQ {
    public static void main(String[] args) {
        int V = 5, src = 0;
        int[][] edges = {
                {0, 1, 4}, {0, 2, 8}, {1, 4, 6},
                {2, 3, 2}, {3, 4, 10}
        };
        System.out.println(Arrays.toString(dijkstra(V, edges, src)));
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] dijkstra(int V, int[][] edges, int src) {
        //Create adj list
        List<Pair>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a -> a.i));
        pq.add(new Pair(0, src));

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
                }
            }
        }
        return dist;
    }
}