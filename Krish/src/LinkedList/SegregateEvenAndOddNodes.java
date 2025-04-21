package Krish.src.LinkedList;

//Problem: https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
//Related doc: https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
//Time complexity: O(n)
//Space complexity: O(1)

public class SegregateEvenAndOddNodes {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(11);

        System.out.print("Original Linked list: ");
        printList(head);
        head = segregateEvenOdd(head);
        System.out.print("\nModified Linked list: ");
        printList(head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node segregateEvenOdd(Node head) {
        Node oddHead = new Node(-1), oddTail = oddHead;
        Node evenHead = new Node(-1), evenTail = evenHead;
        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 != 0) // If odd Node,append to odd LinkedList
            {
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else // If Even Node,append to even LinkedList
            {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            curr = curr.next;
        }

        // Terminate the odd list
        oddTail.next = null;

        // Appending Odd LinkedList at end of EvenLinkedList
        evenTail.next = oddHead.next;

        // Return the new head of the combined list (even head)
        return evenHead.next;
    }
}