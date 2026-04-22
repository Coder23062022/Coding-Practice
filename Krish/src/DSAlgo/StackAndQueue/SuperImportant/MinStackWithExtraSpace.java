package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import java.util.Stack;

//Problem: https://leetcode.com/problems/min-stack/
//video source: https://www.youtube.com/watch?v=wHDm-N2m2XY&ab_channel=ShradhaKhapra
//Time complexity: O(1)
//Space complexity: O(2n) -> As we are storing both val and minVal in the stack

public class MinStackWithExtraSpace {
    static class Pair {
        int val;
        int minVal;

        Pair(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    Stack<Pair> st;

    public MinStackWithExtraSpace() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair(val, val));
        } else {
            int minVal = Math.min(val, st.peek().minVal);
            st.push(new Pair(val, minVal));
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return st.peek().minVal;
    }
}