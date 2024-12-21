package Krish.src.LinkedList;

public class MidElementOfLinkedList {
    Node head;

    static class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        MidElementOfLinkedList linkedList = new MidElementOfLinkedList();
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);
        linkedList.head.next.next.next.next = new Node(5);
        linkedList.head.next.next.next.next.next = new Node(6);

        // print the linked list
        Node pointer = linkedList.head;
        System.out.print("LinkedList: ");
        while (pointer != null) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }

        // Find the middle element
        Node ptr1 = linkedList.head;
        Node ptr2 = linkedList.head;

        while (ptr1 != null && ptr1.next != null) {
            //Increase the ptr1 by 2 and ptr2 by 1, if ptr1 points to last element then ptr2 will point to the middle element.
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }
        System.out.println("\nMiddle Element: " + ptr2.value);
    }
}