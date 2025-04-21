package Krish.src.Graph;

import java.util.LinkedList;

public class DFS {
    static int V;
    static LinkedList<Integer>[] adj;

    DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    static void addEdge(int v, int e) {
        adj[v].add(e);
    }

    static void depthFirstTraversal() {
        boolean[] visited = new boolean[V];

        //If the source vertex is not provided, call the recursive helper function to print DFS traversal starting from all
        //vertices one by one.
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                depthFirstTraversalUtil(i, visited);
        }
    }

    static void depthFirstTraversalUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex.
        for (int n : adj[v]) {
            if (!visited[n]) {
                depthFirstTraversalUtil(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        new DFS(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");
        depthFirstTraversal();
    }
}