package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import java.util.ArrayList;
import java.util.Stack;

//Problem: https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
//Video source: https://www.youtube.com/watch?v=e7XQLtOQM3I&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=6
//Time complexity: O(2n)
//Space complexity: O(2n)

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(nextSmallerElement(nums));
    }

    static ArrayList<Integer> nextSmallerElement(int[] nums) {
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

        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int i : res) {
            list.add(i);
        }
        return list;
    }
}