package Krish.src.Graph;

import java.util.LinkedList;

public class BFS {
    static int V;
    static LinkedList<Integer>[] adj;

    BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    static void addEdge(int v, int e) {
        adj[v].add(e);
    }

    static void breadthFirstTraversal(int startingVertex) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(startingVertex);
        visited[startingVertex] = true;

        while (!queue.isEmpty()) {
            startingVertex = queue.poll();
            System.out.print(startingVertex + " ");

            //Finding the neighbours.
            for (int n : adj[startingVertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        new BFS(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        breadthFirstTraversal(2);
    }
}
