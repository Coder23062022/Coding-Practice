package Krish.src.DSAlgo.Graph.ShortestPath;

//Problem: https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
//Video source: https://www.youtube.com/watch?v=0vVofAhAYjc&ab_channel=takeUforward
//Time complexity: O(V^3)
//Space complexity: O(1), but if considering the dist matrix space then its O(V^2)

public class FloydWarshallAlgo {
    public static void main(String[] args) {
        int INF = 100000000;
        int[][] dist = {{0, 4, INF, 5, INF},
                {INF, 0, 1, INF, 6},
                {2, INF, 0, 3, INF},
                {INF, INF, 1, 0, 2},
                {1, INF, INF, 4, 0}};

        floydWarshall(dist);
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void floydWarshall(int[][] dist) {
        int V = dist.length;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != 1e8 && dist[k][j] != 1e8)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}