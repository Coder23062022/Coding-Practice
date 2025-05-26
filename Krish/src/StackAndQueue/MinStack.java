package Krish.src.StackAndQueue;

import java.util.Stack;

//Problem: https://leetcode.com/problems/min-stack/
//video source: https://www.youtube.com/watch?v=wHDm-N2m2XY&ab_channel=ShradhaKhapra
//Time complexity: O(1)
//Space complexity: O(n)

public class MinStack {
    Stack<Long> stack;
    Long minVal;

    public MinStack() {
        stack = new Stack<>();
        minVal = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if (stack.isEmpty()) {
            stack.push(value);
            minVal = value;
        } else {
            if (value < minVal) {
                stack.push(2 * value - minVal);
                minVal = value;
            } else {
                stack.push(value);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek() < minVal) {
            minVal = 2 * minVal - stack.peek();
        }
        stack.pop();
    }

    public int top() {
        if (stack.peek() < minVal) {
            return minVal.intValue();
        }
        return stack.peek().intValue();
    }

    public int getMin() {
        return minVal.intValue();
    }
}