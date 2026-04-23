package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import java.util.Stack;

//Problem: https://leetcode.com/problems/sum-of-subarray-minimums
//video source: https://www.youtube.com/watch?v=v0e8p9JCgRc
//Time complexity: O(5n) ≈ O(n)
//Space complexity: O(5n) ≈ O(n)

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int[] pse = previousSmallerElement(arr);
        int[] nse = nextSmallerElement(arr);
        int n = arr.length;

        long sum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            sum += (long) left * right * arr[i];
            sum = sum % mod;
        }
        return (int) sum;
    }

    static int[] nextSmallerElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    static int[] previousSmallerElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}