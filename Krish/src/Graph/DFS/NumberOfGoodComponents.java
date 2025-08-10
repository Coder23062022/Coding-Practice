package Krish.src.Graph.DFS;

import java.util.ArrayList;

//Problem: https://practice.geeksforgeeks.org/contest/interview-series-60/problems/#

public class NumberOfGoodComponents {
    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        System.out.println("Number of good component is: " + findNumberOfGoodComponent(V, adj));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V + 1];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> nodes = new ArrayList<>();
                DFSUtil(i, visited, nodes, adj);
                boolean isCompletelyConnected = true;
                for (int u : nodes) {
                    //Checking every node's degree is equal to (number of vertices in the graph - 1) or not.
                    //If the graph is completely connected, then every node's degree must be equal to (number of vertices in the graph - 1).
                    if (adj.get(u).size() != nodes.size() - 1) {
                        isCompletelyConnected = false;
                        break;
                    }
                }
                if (isCompletelyConnected) count++;
            }
        }
        return count;
    }

    static void DFSUtil(int i, boolean[] visited, ArrayList<Integer> nodes, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = true;
        nodes.add(i);
        for (int v : adj.get(i)) {
            if (!visited[v])
                DFSUtil(v, visited, nodes, adj);
        }
    }
}
