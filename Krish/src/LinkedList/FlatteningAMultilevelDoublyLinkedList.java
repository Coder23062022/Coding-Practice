package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
//Video source: https://www.youtube.com/watch?v=I8b0rff5F9M&ab_channel=ShradhaKhapra
//Time complexity: O(n)
//Space complexity: O(n)

public class FlatteningAMultilevelDoublyLinkedList {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    //TODO: Create the doubly linked list with child node and call the flatten method

    static Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;

                while (curr.next != null) {
                    curr = curr.next;
                }

                if (next != null) {
                    curr.next = next;
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}