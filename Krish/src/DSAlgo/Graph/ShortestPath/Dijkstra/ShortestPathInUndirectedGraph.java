package Krish.src.DSAlgo.Graph.ShortestPath.Dijkstra;

//Problem: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
//Video source: https://www.youtube.com/watch?v=C4gxoTaI71U&t=2s&ab_channel=takeUforward
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.*;

public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        int[][] adj = {{1, 3}, {0, 2}, {1, 6}, {0, 4}, {3, 5}, {4, 6}, {2, 5, 7, 8}, {6, 8}, {7, 6}};

        //Create the adj list from the given adj array
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < adj[i].length; j++) {
                innerList.add(adj[i][j]);
            }
            adjList.add(innerList);
        }

        int src = 0;
        System.out.println(Arrays.toString(shortestPath(adjList, src)));
    }

    static class Pair {
        int vertex;
        int dist;

        Pair(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0));

        while (!q.isEmpty()) {
            int node = q.peek().vertex;
            int d = q.peek().dist;
            q.poll();

            for (int n : adj.get(node)) {
                if (d + 1 < dist[n]) {
                    dist[n] = d + 1;
                    q.offer(new Pair(n, dist[n]));
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}