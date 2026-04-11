package Krish.src.Graph.MST_DisjointSet;

//Problem: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
//Video source: https://www.youtube.com/watch?v=mJcZjjKzeqk&t=955s&ab_channel=takeUforward
//Time complexity: O((E+V)*log(V))
//Space complexity: O(E+V)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}};
        System.out.println(spanningTree(3, graph));
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int spanningTree(int V, int[][] edges) {
        //Create adj list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a -> a.i));
        pq.add(new Pair(0, 0));

        int[] vis = new int[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            int wt = pq.peek().i;
            int node = pq.peek().j;
            pq.poll();

            if (vis[node] == 1) continue;

            sum += wt;
            vis[node] = 1;
            for (Pair n : adj.get(node)) {
                int v = n.i;
                int w = n.j;

                //Don't mark visited here, only add in queue if not visited
                if (vis[v] == 0) {
                    pq.add(new Pair(v, w));
                }
            }
        }
        return sum;
    }
}