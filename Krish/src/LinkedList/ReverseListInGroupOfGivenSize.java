package Krish.src.LinkedList;

//Problem: https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
//Reference doc: https://www.geeksforgeeks.org/reverse-a-linked-list-in-groups-of-given-size-iterative-approach/
//Time Complexity: O(n), where n is the number of nodes in linked list
//Space Complexity: O(1)

public class ReverseListInGroupOfGivenSize {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int k = 3;
        System.out.println("Linkedlist before reverse:");
        printList(head);
        System.out.println("\nLinkedlist after reverse:");
        printList(reverseKGroupIterative(head, k));
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static Node reverseKGroupIterative(Node head, int k) {
        if (head == null || head.next == null) return head;

        Node curr = head;
        Node newHead = null;
        Node tail = null;

        while (curr != null) {
            Node groupHead = curr;

            Node prev = null;
            Node next;
            int count = 0;
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }


            // If newHead is null, set it to the
            // last node of the first group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect the previous group to the
            // current reversed group
            if (tail != null) {
                tail.next = prev;
            }

            // Move tail to the end of the
            // reversed group
            tail = groupHead;
        }
        return newHead;
    }
}