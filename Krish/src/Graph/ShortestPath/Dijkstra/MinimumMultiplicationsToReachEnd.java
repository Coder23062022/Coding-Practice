package Krish.src.Graph.ShortestPath.Dijkstra;

//Problem: https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
//Video source: https://www.youtube.com/watch?v=_BvEJ3VIDWw&t=934s&ab_channel=takeUforward
//Time complexity: O(100000 * n), n = arr.length
//Space complexity: O(mod)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int start = 7, end = 66175;
        System.out.println(minimumMultiplications(arr, start, end));
    }

    static class Pair {
        int node;
        int steps;

        Pair(int node, int steps) {
            this.node = node;
            this.steps = steps;
        }
    }

    static int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;

        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int steps = q.peek().steps;
            q.poll();

            for (int a : arr) {
                int num = (node * a) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    q.add(new Pair(num, dist[num]));
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) return -1;
        return dist[end];
    }
}