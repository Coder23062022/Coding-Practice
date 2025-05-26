package Krish.src.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

//Problem: https://www.geeksforgeeks.org/next-smaller-element/
//Video source: https://www.youtube.com/watch?v=e7XQLtOQM3I&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=5&ab_channel=takeUforward
//Time complexity: O(2n)
//Space complexity: O(2n)

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElement(nums)));
    }

    static int[] nextSmallerElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
}