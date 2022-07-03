package src.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectAndRemoveLoopInALinkedListUsingHashing {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    boolean removeLoop(Node head) {
        Set<Node> hs = new HashSet<>();
        Node prev = null;
        while (head != null) {
            if (hs.contains(head)) {
                // Removing the loop here
                prev.next = null;
                return true;
            } else {
                hs.add(head);
                prev = head;
                head = head.next;
            }
        }
        return false;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DetectAndRemoveLoopInALinkedListUsingHashing list = new DetectAndRemoveLoopInALinkedListUsingHashing();
        head = new Node(20);
        head.next = new Node(4);
        head.next.next = new Node(15);
        head.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next = head;

        if (list.removeLoop(head)) {
            System.out.println("Linked List after removing loop");
            list.printList(head);
        } else
            System.out.println("No Loop found");
    }
}