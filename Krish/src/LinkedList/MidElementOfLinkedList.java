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
        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            //Increase the slow by 1 and fast by 2, if fast points to last element then slow will point to the middle element.
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("\nMiddle Element: " + slow.value);
    }
}