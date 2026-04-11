package Krish.src.Graph.ShortestPath.Dijkstra;

//Problem: https://leetcode.com/problems/cheapest-flights-within-k-stops
//Video source: https://www.youtube.com/watch?v=9XybHVqTHcQ&ab_channel=takeUforward
//Time complexity: O(E), E = flights.length
//Space complexity: O(n)

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class Triplet {
        int stops;
        Pair pair;

        Triplet(int stops, Pair pair) {
            this.stops = stops;
            this.pair = pair;
        }
    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Create adj list
        List<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adj[u].add(new Pair(v, w));
        }

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, new Pair(src, 0)));

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        while (!q.isEmpty()) {
            int stops = q.peek().stops;
            int node = q.peek().pair.i;
            int cost = q.peek().pair.j;
            q.poll();

            if (stops > k) continue;
            for (Pair p : adj[node]) {
                int neighbor = p.i;
                int price = p.j;

                if (cost + price < costs[neighbor]) {
                    costs[neighbor] = cost + price;
                    q.add(new Triplet(stops + 1, new Pair(neighbor, costs[neighbor])));
                }
            }
        }
        if (costs[dst] == Integer.MAX_VALUE) return -1;
        return costs[dst];
    }
}