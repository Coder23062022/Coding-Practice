package src.Stack;

//Problem: https://leetcode.com/problems/longest-valid-parentheses/
//Video source: https://www.youtube.com/watch?v=VdQuwtEd10M&t=437s&ab_channel=AlgorithmsMadeEasy

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println("Length of the longest valid parenthesis is: " + longestValidParenthesesMethod2(s));
    }

    //Time complexity: O(n)
    //Space complexity: O(n)
    static int longestValidParenthesesMethod1(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(len, max);
                }
            }
        }
        return max;
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    static int longestValidParenthesesMethod2(String s) {
        int open = 0, close = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                int len = open + close;
                max = Math.max(max, len);
            } else if (close > open) {
                open = close = 0;
            }
        }

        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                int len = open + close;
                max = Math.max(max, len);
            } else if (open > close) {
                open = close = 0;
            }
        }
        return max;
    }
}
