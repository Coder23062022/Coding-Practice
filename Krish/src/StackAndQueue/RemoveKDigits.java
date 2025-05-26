package Krish.src.StackAndQueue;

import java.util.Stack;

//Problem: https://leetcode.com/problems/remove-k-digits/
//Video source: https://www.youtube.com/watch?v=jmbuRzYPGrg&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=14&ab_channel=takeUforward
//Time complexity: O(n) + O(k)
//Space complexity: O(n)

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }

    static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        //corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}