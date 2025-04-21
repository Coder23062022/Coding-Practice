package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//Video source: https://www.youtube.com/watch?v=XVuQxVej6y8&ab_channel=NeetCode
//Time complexity: O(n), n is the length of the linked list
//Space complexity: O(1)

public class DeleteKthLastNode {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int k = 5;
        insert(5);
        insert(4);
        insert(3);
        insert(2);
        insert(1);

        // Delete the 3rd node from the last
        deleteNode(k);
    }

    static void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Two pointer approach.
    static void deleteNode(int key) {
        Node dummyNode = new Node(0, head);
        Node left = dummyNode;
        Node right = head;

        for (int i = 0; i < key; i++) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        //By now, left must be pointing to one node before the node to be deleted.
        //So, delete the link left is pointing to now.
        left.next = left.next.next;

        printList(dummyNode.next);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}