package Krish.src.DSAlgo.Graph.ShortestPath;

//Problem: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
//Video source: https://www.youtube.com/watch?v=PwMVNSJ5SLI&t=5s&ab_channel=takeUforward
//Time complexity: O(V^3)
//Space complexity: O(V^2)

import java.util.Arrays;

public class CityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        int n = 4, distanceThreshold = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

    static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        floydWarshall(dist);

        int countCity = n, cityNo = -1;
        for (int city = 0; city < n; city++) {
            int count = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (city != adjCity && dist[city][adjCity] <= distanceThreshold) count++;
            }

            if (count <= countCity) {
                countCity = count;
                cityNo = city;
            }
        }
        return cityNo;
    }

    static void floydWarshall(int[][] dist) {
        int V = dist.length;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}