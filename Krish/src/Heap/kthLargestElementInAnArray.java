package Krish.src.Heap;

import java.util.*;

//Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/
//Video source: https://www.youtube.com/watch?v=iiYmgrD4h6M&ab_channel=CodingSimplified
//Time Complexity: O(klogk + (n-k)logk)
//Space complexity: O(k)

public class kthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 2;
        System.out.print("K'th largest element is " + findKthLargestWithMinHeap(arr, k));
        System.out.print("\nK'th largest element is " + findKthLargestWithMaxHeap(arr, k));
    }

    static int findKthLargestWithMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    static int findKthLargestWithMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }
}