package Krish.src.Graph.ShortestPath;

//Problem: https://takeuforward.org/plus/dsa/problems/bellman-ford-algorithm
//Video source: https://www.youtube.com/watch?v=0vVofAhAYjc&ab_channel=takeUforward
//Time complexity: O(E * V)
//Space complexity: O(V)

import java.util.Arrays;

public class BellmanFordAlgo {
    public static void main(String[] args) {
        int V = 5, src = 0;
        int[][] edges = new int[][]{
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };

        int[] ans = bellmanFord(V, edges, src);
        for (int dist : ans) System.out.print(dist + " ");
    }

    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        //Relaxation of all the edges V times, not (V - 1) as we
        //need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    if (i == V - 1)
                        return new int[]{-1}; //If this is the Vth relaxation, then there is a negative cycle
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }
}