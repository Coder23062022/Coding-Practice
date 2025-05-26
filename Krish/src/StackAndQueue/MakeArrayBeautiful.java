package src.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//Problem: https://practice.geeksforgeeks.org/contest/interview-series-60/problems/#
//Time complexity: O(n)
//Space complexity: O(n)

public class MakeArrayBeautiful {
    public static void main(String[] args) {
        int[] arr = {2, 1, -4, 3, -5, 2, 6, -3};
        System.out.println(makeBeautiful(arr));
    }

    static ArrayList<Integer> makeBeautiful(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            if (stack.isEmpty()) {
                stack.push(j);
            } else {
                if (j >= 0 && stack.peek() >= 0) {
                    stack.push(j);
                } else if (j < 0 && stack.peek() < 0) {
                    stack.push(j);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res;
    }
}
