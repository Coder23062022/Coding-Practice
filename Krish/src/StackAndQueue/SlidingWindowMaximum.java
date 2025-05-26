package Krish.src.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Problem: https://leetcode.com/problems/sliding-window-maximum/
//Video source: https://www.youtube.com/watch?v=NwBvene4Imo&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=17&ab_channel=takeUforward
//Time complexity: O(n), it can be observed that every element of the array is added and removed at most once. So there are a total of 2n operations.
//Space complexity: O(k), queue is storing maximum of k element at a time

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ri = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k - 1) res[ri++] = nums[dq.peekFirst()];
        }
        return res;
    }
}