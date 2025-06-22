package Krish.src.LinkedList;

//Problem: https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
//Video source: https://www.youtube.com/watch?v=kvCYxPKpPGg&ab_channel=AnujKumarSharma
//Time complexity: O(n)
//Space complexity: O(1)

public class FlatteningAMultilevelLinkedList {
    static class Node {
        int data;
        Node next, child;

        Node(int x) {
            data = x;
            next = null;
            child = null;
        }
    }

    public static void main(String[] args) {
        //Linked List -
        // 1 -> 2 -> 3
        // |        |
        // 4 -> 5   6
        // |
        // 7
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.child = new Node(4);
        head.child.next = new Node(5);
        head.next.next.child = new Node(6);
        head.child.child = new Node(7);
        flattenList(head);
        printList(head);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    static void flattenList(Node head) {
        if (head == null) return;

        Node tail = head;
        while (tail.next != null)
            tail = tail.next;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                tail.next = curr.child;

                Node tmp = curr.child;
                while (tmp.next != null)
                    tmp = tmp.next;
                tail = tmp;

                curr.child = null;
            }
            curr = curr.next;
        }
    }
}