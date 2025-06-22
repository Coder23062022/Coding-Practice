package Krish.src.Heap;

import java.util.*;

//Problem: https://leetcode.com/problems/top-k-frequent-elements
//Video source: https://www.youtube.com/watch?v=YPTqKIgVk-k&ab_channel=NeetCode
//Solution: https://www.youtube.com/watch?v=Wh3A29psE_Y&t=691s&ab_channel=Techdose
//Time complexity: O(n + klogk)
//Space complexity: O(d), d is the count of distinct elements in the array

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println("Top " + k + " Frequent Elements are:");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int val : nums)
            mp.put(val, mp.getOrDefault(val, 0) + 1);

        //Priority queue (Min-Heap) with custom comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
            if (pq.size() > k)
                pq.poll();
        }

        //Store the result
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
