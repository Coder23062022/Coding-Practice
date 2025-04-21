package Krish.src.LinkedList;

//Problem: https://www.geeksforgeeks.org/problems/find-length-of-loop/1
//Related doc: https://takeuforward.org/linked-list/length-of-loop-in-linked-list
//Time complexity: O(n)
//Space complexity: O(1)

public class LengthOfALoopInALinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    int lengthOfALoopInALinkedList(Node head) {
        if (head == null || head.next == null)
            return 0;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                fast = fast.next;
                while (slow != fast) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LengthOfALoopInALinkedList list = new LengthOfALoopInALinkedList();
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        System.out.println("Length of the the loop is: " + list.lengthOfALoopInALinkedList(head));
    }
}