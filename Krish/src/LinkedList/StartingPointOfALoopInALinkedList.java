package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/linked-list-cycle-ii/
//Video source: https://www.youtube.com/watch?v=2Kd0KKmmHFc&ab_channel=takeUforward
//Related doc: https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/
//Time complexity: O(n)
//Space complexity: O(1)

public class StartingPointOfALoopInALinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node startingPointOfLoop(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StartingPointOfALoopInALinkedList list = new StartingPointOfALoopInALinkedList();
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        System.out.println("Starting point of the loop is: " + list.startingPointOfLoop(head).data);
    }
}