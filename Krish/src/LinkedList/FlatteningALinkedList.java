package Krish.src.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

//Problem: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
//Related doc: https://www.geeksforgeeks.org/flattening-a-linked-list/
//Time complexity: O(n * m * log(n)) – where n is the no of nodes in the main linked list (reachable using the next pointer) and m is the no of nodes in a single sub-linked list (reachable using a bottom pointer)
//Space complexity: O(n)

public class FlatteningALinkedList {
    static class Node {
        int data;
        Node next, bottom;

        Node(int newData) {
            data = newData;
            next = bottom = null;
        }
    }

    public static void main(String[] args) {
        /* Create a hard-coded linked list:
            5 -> 10 -> 19 -> 28
            |    |     |
            7    20    22
            |          |
            8          50
            |
            30
        */

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);

        head = flatten(head);
        printList(head);
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    static Node flatten(Node root) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.data));
        Node head = null;
        Node tail = null;

        while (root != null) {
            pq.add(root);
            root = root.next;
        }

        while (!pq.isEmpty()) {
            Node minNode = pq.poll();

            if (head == null) {
                head = minNode;
                tail = minNode;
            } else {
                tail.bottom = minNode;
                tail = tail.bottom;
            }

            if (minNode.bottom != null) {
                pq.add(minNode.bottom);
            }
        }
        return head;
    }
}