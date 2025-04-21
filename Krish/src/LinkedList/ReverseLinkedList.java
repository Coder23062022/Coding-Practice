package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/reverse-linked-list/description/
//Video source: https://www.youtube.com/watch?v=D2vI2DNJGd8&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1), if we use iterative approach. For recursive approach, it will be O(n).

public class ReverseLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    Node reverseIterativeApproach(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    Node reverseRecursiveApproach(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = reverseRecursiveApproach(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    // prints content of the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverseIterativeApproach(head);
//        head = list.reverseRecursiveApproach(head);
        System.out.println("\nReversed linked list ");
        list.printList(head);
    }
}