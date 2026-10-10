package Krish.src.DSAlgo.Graph.ShortestPath.Dijkstra;

//Problem: https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
//Video source: https://www.youtube.com/watch?v=_BvEJ3VIDWw&t=934s&ab_channel=takeUforward
//Time complexity: O(1000 * n), n = arr.length
//Space complexity: O(mod)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    static void main() {
        int[] arr = {3, 4, 65};
        int start = 7, end = 66175;
        System.out.println(minimumMultiplications(arr, start, end));
    }

    static class Pair {
        int steps;
        int node;

        Pair(int steps, int node) {
            this.steps = steps;
            this.node = node;
        }
    }

    static int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 1000;

        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));

        while (!q.isEmpty()) {
            int steps = q.peek().steps;
            int node = q.peek().node;
            q.poll();

            for (int a : arr) {
                int num = (node * a) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    q.add(new Pair(dist[num], num));
                }
            }
        }
        return dist[end] == 1e9 ? -1 : dist[end];
    }
}