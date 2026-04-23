package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import java.util.Stack;

//Problem: https://www.geeksforgeeks.org/problems/sum-of-max-of-subarrays/1
//video source: https://www.youtube.com/watch?v=v0e8p9JCgRc
//Time complexity: O(5n) ≈ O(n)
//Space complexity: O(5n) ≈ O(n)

public class SumOfSubarrayMaximums {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMax(arr));
    }

    public static int sumSubarrayMax(int[] arr) {
        int[] pse = previousGreaterElement(arr);
        int[] nse = nextGreaterElement(arr);
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

    static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }

    static int[] previousGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] pge = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }
}
