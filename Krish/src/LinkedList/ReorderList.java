package src.LinkedList;

public class ReorderList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("Before reordering linked list is: ");
        printList(head);
        reorderList(head);
        System.out.println("\nAfter reordering linked list is: ");
        printList(head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static void reorderList(Node head) {
        Node middle = findMiddle(head);
        Node reverse = reverseSecondHalf(middle.next);
        middle.next = null;
        mergeTwoHalves(head, reverse);
    }

    static Node findMiddle(Node head) {
        if (head == null || head.next == null) return head;
        Node first = head;
        Node second = head.next;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    static Node reverseSecondHalf(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void mergeTwoHalves(Node first, Node second) {
        Node temp;
        while (first != null && second != null) {
            temp = first.next;
            first.next = second;
            first = second;
            second = temp;
        }
    }
}
