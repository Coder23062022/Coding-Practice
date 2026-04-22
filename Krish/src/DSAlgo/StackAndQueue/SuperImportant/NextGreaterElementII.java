package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import java.util.Arrays;
import java.util.Stack;

//Problem: https://leetcode.com/problems/next-greater-element-ii/
//Video source: https://www.youtube.com/watch?v=7PrncD7v9YQ&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=7
//Time complexity: O(2n)
//Space complexity: O(2n)

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElementII(nums)));
    }

    static int[] nextGreaterElementII(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return res;
    }
}