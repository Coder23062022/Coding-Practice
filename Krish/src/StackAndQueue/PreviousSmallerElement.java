package Krish.src.StackAndQueue;

//Problem: https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
//Video source: https://www.youtube.com/watch?v=zMdbdGJNlh4&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=7&ab_channel=takeUforward
//Time complexity: O(2n)
//Space complexity: O(2n)

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 4, 5};
        System.out.println(Arrays.toString(previousSmallerElement(nums)));
    }

    static int[] previousSmallerElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
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