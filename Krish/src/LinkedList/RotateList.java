package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/rotate-list/
//Video source: https://www.youtube.com/watch?v=uT7YI7XbTY8&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=23&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class RotateList {
    static class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 10 -> 20 -> 30 -> 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = rotate(head, 6);
        printList(head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node rotate(Node head, int k) {
        if (head == null || k == 0) return head;

        //Find the length of linked list
        Node curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        //Modulo k with length of linked list to handle large values of k
        k = k % len;
        if (k == 0) return head;

        curr.next = head;

        //Traverse the linked list to find the kth node
        curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        //Update the (k + 1)th node as the new head
        head = curr.next;

        curr.next = null;
        return head;
    }
}