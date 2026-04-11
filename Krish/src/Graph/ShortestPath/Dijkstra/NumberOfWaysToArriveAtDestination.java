package Krish.src.Graph.ShortestPath.Dijkstra;

//Problem: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
//Video source: https://www.youtube.com/watch?v=_-0mx0SmYxA&ab_channel=takeUforward
//Time complexity: O(E * logV)
//Space complexity: O(V)

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(countPaths(n, roads));
    }

    static class Pair {
        long i;
        long j;

        Pair(long i, long j) {
            this.i = i;
            this.j = j;
        }
    }

    static int countPaths(int n, int[][] roads) {
        //Create adj list
        List<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : roads) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }

        long[] ways = new long[n];
        ways[0] = 1;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a -> a.i));
        pq.add(new Pair(0, 0));

        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            long d = pq.peek().i;
            long node = pq.peek().j;
            pq.poll();

            for (Pair p : adj[(int) node]) {
                long neighbor = p.i;
                long wt = p.j;

                if (d + wt < dist[(int) neighbor]) {
                    dist[(int) neighbor] = d + wt;
                    pq.add(new Pair(dist[(int) neighbor], neighbor));
                    ways[(int) neighbor] = ways[(int) node];
                } else if (d + wt == dist[(int) neighbor]) {
                    ways[(int) neighbor] = (ways[(int) neighbor] + ways[(int) node]) % mod;
                }
            }
        }
        return (int) ways[n - 1] % mod;
    }
}