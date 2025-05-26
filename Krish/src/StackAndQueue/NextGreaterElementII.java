package Krish.src.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

//Problem: https://leetcode.com/problems/next-greater-element-ii/
//Video source: https://www.youtube.com/watch?v=7PrncD7v9YQ&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=6&ab_channel=takeUforward
//Time complexity: O(2n)
//Space complexity: O(2n)

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElementII(nums)));
    }

    static int[] nextGreaterElementII(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i % n]);
        }
        return res;
    }
}