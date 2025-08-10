package Krish.src.Graph.TopoSort;

//Problem: https://leetcode.com/problems/find-eventual-safe-states/
//Video source: https://www.youtube.com/watch?v=2gtg3VsDGyc&ab_channel=takeUforward
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

    static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        //Reverse the direction of the edges and create a new adj list
        List<Integer>[] adjRev = new ArrayList[V];
        for (int i = 0; i < V; i++) adjRev[i] = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int v : graph[i]) {
                adjRev[v].add(i);
            }
        }

        //Now apply topo sort
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int vertex : adjRev[i]) {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int neighbor : adjRev[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) q.add(neighbor);
            }
        }

        Collections.sort(res);
        return res;
    }
}