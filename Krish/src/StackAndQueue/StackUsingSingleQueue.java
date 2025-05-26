package Krish.src.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

//Problem: https://leetcode.com/problems/implement-stack-using-queues/
//video source: https://www.youtube.com/watch?v=tqQ5fTamIN4&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&ab_channel=takeUforward
//Time complexity: Only push - O(n), but others - O(1)
//Space complexity: O(n)

public class StackUsingSingleQueue {
    Queue<Integer> q = new LinkedList<>();

    // Push operation
    void push(int val) {
        // Add current element
        q.add(val);

        // Pop (or Dequeue) all previous elements and put them after current element
        for (int i = 1; i < q.size(); i++) {
            // this will add front element into rear of queue
            int x = q.remove();
            q.add(x);
        }
    }

    // Removes the top element
    int pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
            return -1;
        }
        return q.remove();
    }

    // Returns top of stack
    int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    //Check for empty stack
    boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingSingleQueue s = new StackUsingSingleQueue();
        s.push(10);
        s.push(20);
        s.push(50);
        System.out.println("Top element :" + s.top());
        System.out.println("Popped lement:" + s.pop());
        s.push(30);
        System.out.println(s.empty());
        System.out.println("Popped lement:" + s.pop());
        System.out.println("Top element :" + s.top());
    }
}