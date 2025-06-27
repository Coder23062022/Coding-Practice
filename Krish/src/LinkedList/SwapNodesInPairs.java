package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/swap-nodes-in-pairs/
//Time Complexity: O(n)
//Space Complexity: O(n/2), if we use recursive approach. For iterative approach, it will be O(1).

public class SwapNodesInPairs {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        System.out.println("Linkedlist before swap:");
        printList(head);
        System.out.println("\nLinkedlist after swap:");
        printList(swapPairs(head));
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static Node swapPairs(Node head) {
        if (head == null || head.next == null) return head;
        Node dummyNode = new Node(-1);
        Node curr = head, prev = dummyNode;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return dummyNode.next;
    }

    static Node swapPairsByDataSwapping(Node head) {
        if (head == null || head.next == null) return head;
        Node curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;

            curr = curr.next.next; //Jump to the 3rd node to swap the next pair
        }
        return head;
    }

    static Node swapPairsWithRecursion(Node head) {
        if (head == null) return null;
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0, k = 2;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) head.next = swapPairsWithRecursion(next);
        return prev;
    }
}