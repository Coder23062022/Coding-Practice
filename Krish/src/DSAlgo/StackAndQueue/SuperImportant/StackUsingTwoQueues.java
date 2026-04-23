package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import java.util.LinkedList;
import java.util.Queue;

//Problem: https://leetcode.com/problems/implement-stack-using-queues/
//video source: https://www.youtube.com/watch?v=sFvP5Ois0CE
//Time complexity: Only push - O(n), but others - O(1)
//Space complexity: O(n)

public class StackUsingTwoQueues {
    static class Stack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        Stack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        void push(int x) { //q1 will give the ans

            //Move all elements from q1 to q2.
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            //Push to q1
            q1.add(x);

            //Move all elements from q2 to q1.
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }

        int pop() {
            return q1.isEmpty() ? -1 : q1.remove();
        }

        int top() {
            return q1.isEmpty() ? -1 : q1.peek();
        }

        boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.empty());

        System.out.println("Top element:" + s.top());
        System.out.println("Popped lement:" + s.pop());

        System.out.println("Top element:" + s.top());
        System.out.println("Popped lement:" + s.pop());

        System.out.println("Top element:" + s.top());
        System.out.println("current size: " + s.empty());
        System.out.println("Popped lement:" + s.pop());
    }
}