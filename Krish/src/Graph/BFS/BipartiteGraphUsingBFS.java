package Krish.src.Graph.BFS;

//Problem: https://www.geeksforgeeks.org/problems/bipartite-graph/1
//Problem: https://leetcode.com/problems/is-graph-bipartite/
//Video source: https://www.youtube.com/watch?v=-vu34sct1g8&t=192s&ab_channel=takeUforward
//Time complexity: O(V + 2E)
//Space complexity: O(V)

import java.util.*;

public class BipartiteGraphUsingBFS {
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0, 1}, {1, 2}};
        System.out.println(isBipartite(V, edges));
    }

    static boolean isBipartite(int V, int[][] edges) {
        //Create adj list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, adj, colors)) return false;
            }
        }
        return true;
    }

    static boolean bfs(int node, List<Integer>[] adj, int[] colors) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        colors[node] = 1;

        while (!q.isEmpty()) {
            int currNode = q.peek();
            q.poll();

            for (int neighbor : adj[currNode]) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[currNode];
                    q.offer(neighbor);
                } else if (colors[neighbor] == colors[currNode]) {
                    return false;
                }
            }
        }
        return true;
    }
}