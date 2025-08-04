package Krish.src.Graph;

import java.util.LinkedList;

//Video source: https://www.youtube.com/watch?v=Qzf1a--rhp8&t=943s&ab_channel=takeUforward
//Time complexity: O(V + 2E)
//Space complexity: O(n)

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
        dfsUsingRecursion(0, visited);
    }

    static void dfsUsingRecursion(int node, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[node] = true;
        System.out.print(node + " ");

        // Recur for all the vertices adjacent to this vertex.
        for (int n : adj[node]) {
            if (!visited[n]) {
                dfsUsingRecursion(n, visited);
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