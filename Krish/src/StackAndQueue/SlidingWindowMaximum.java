package Krish.src.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Problem: https://leetcode.com/problems/sliding-window-maximum/
//Video source: https://www.youtube.com/watch?v=NwBvene4Imo&ab_channel=takeUforward
//Video source: https://www.youtube.com/watch?v=XwG5cozqfaM&t=817s&ab_channel=ShradhaKhapra
//Time complexity: O(n), it can be observed that every element of the array is added and removed at most once. So there are a total of 2n operations.
//Space complexity: O(k), queue is storing maximum of k elements at a time

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            //Maintaining the window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            //If curr element is greater than all the existing elements in the deque,
            //then remove all the existing elements from deque and then add the curr element. Because we want to keep the max element only.
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);

            //Start adding into the result after i value passes the kth iteration.
            //Ex:k = 3, so after i reaches the (k-1) = 2nd index, start adding into the result
            if (i >= k - 1) {
                res[index] = nums[dq.peekFirst()];
                index++;
            }
        }
        return res;
    }
}