package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import java.util.Stack;

//Problem: https://leetcode.com/problems/implement-queue-using-stacks/
//video source: https://www.youtube.com/watch?v=sFvP5Ois0CE
//Time complexity: Only push - O(2n), but others - O(1)
//Space complexity: O(2n)

public class QueueUsingTwoStacks {
    static class Queue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        Queue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        void push(int x) { //s1 will give the ans
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        int pop() {
            return s1.pop();
        }

        int peek() {
            return s1.peek();
        }

        boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.pop());
        System.out.println(q.empty());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}