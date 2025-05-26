package Krish.src.StackAndQueue;

import java.util.Stack;

//Problem: https://leetcode.com/problems/valid-parentheses/
//Time complexity: O(n)
//Time complexity: O(n)

public class CheckOrderedBalancedParentheses {
    public static void main(String[] args) {
        System.out.println("Parentheses are balanced? - " + checkForBalancedParentheses("[{}]"));
        System.out.println("Parentheses are balanced? - " + checkStack("[{]}"));
    }

    //Method 1
    static Boolean checkForBalancedParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            //If the current character is a starting bracket '(' or '{' or '[' then push
            //it to stack. If the current character is a closing bracket ')' or '}' or
            //']' then pop from stack and if the popped character is not matching starting
            //bracket, then parenthesis are not balanced.
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
        }
        //After the entire traversal, if the stack is empty then parentheses are balanced.
        return stack.isEmpty();
    }

    //Method 2
    static boolean checkStack(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
                continue;
            }

            switch (str.charAt(i)) {
                case ')':
                    if (s.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (s.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (s.pop() != '[')
                        return false;
                    break;
            }
        }
        return s.isEmpty();
    }
}