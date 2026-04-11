package Krish.src.Graph.ShortestPath.Dijkstra;

//Problem: https://leetcode.com/problems/network-delay-time
//Video source: https://www.youtube.com/watch?v=hptQEIpvaxM&ab_channel=codestorywithMIK
//Time complexity: O(E * logV)
//Space complexity: O(V)

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = dijkstra(n, times, k);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    static int[] dijkstra(int n, int[][] times, int k) {
        List<Pair>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new Pair(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a -> a.i));
        pq.add(new Pair(0, k));

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