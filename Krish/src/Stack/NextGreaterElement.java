package src.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Problem: https://leetcode.com/problems/next-greater-element-i/
//Similar problem: https://www.geeksforgeeks.org/next-smaller-element/
//Time complexity: O(n)
//Space complexity: O(n)

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        //Preparing the map.
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek())
                map.put(stack.pop(), num);
            stack.push(num);
        }

        int i = 0;
        for (int num : nums1) {
            result[i++] = map.getOrDefault(num, -1);
        }
        return result;
    }
}
