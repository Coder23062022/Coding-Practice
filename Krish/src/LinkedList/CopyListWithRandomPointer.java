package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/copy-list-with-random-pointer/
//Video source: https://www.youtube.com/watch?v=q570bKdrnlw&ab_channel=takeUforward
//Time complexity: O(3n), because we are traversing the linked list three times.
//Space complexity: O(1), as we are storing all the cloned nodes in the original linked list itself, no extra space is required.

public class CopyListWithRandomPointer {
    static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        // Creating a linked list with random pointer
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Print the original list
        System.out.println("Original linked list:");
        printList(head);

        // Function call
        Node clonedList = cloneLinkedList(head);

        System.out.println("Cloned linked list:");
        printList(clonedList);
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "(");
            if (head.random != null)
                System.out.print(head.random.data + ")");
            else
                System.out.print("null" + ")");

            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    static Node cloneLinkedList(Node head) {
        //Create the copy of current node in between the current node and next node
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        //Connect the random pointer for the copied nodes
        temp = head;
        while (temp != null) {
            if (temp.random == null) {
                temp.next.random = null;
            } else {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //Connect the next pointer for the copied nodes
        temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}