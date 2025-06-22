package Krish.src.Heap;

import java.util.PriorityQueue;

//Problem: https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
//Video source: https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9&ab_channel=AdityaVerma
//Time complexity: O(nlogk)
//Space complexity: O(n)

public class ConnectNRopesWithMinimumCost {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }

    static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) pq.add(j);

        int cost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            cost += first + second;
            pq.add(first + second);
        }
        return cost;
    }
}