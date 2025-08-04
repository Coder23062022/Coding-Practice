package Krish.src.Graph;

import java.util.LinkedList;

//Video source: https://www.youtube.com/watch?v=-tgVpUgsQ5k&ab_channel=takeUforward
//Time complexity: O(V + 2E)
//Space complexity: O(n)

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
            int node = queue.poll();
            System.out.print(node + " ");

            //Finding the neighbours from adjacency list.
            for (int n : adj[node]) {
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