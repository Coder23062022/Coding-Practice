package src.LinkedList;

public class DeleteKthLastNode {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        int k = 3;
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
        Node first = head;
        Node second = head;
        for (int i = 0; i < key; i++) {
            second = second.next;
        }

        //If you want to delete the head node, then it will return empty list.
        if (second == null) return;

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        //By now, first must be pointing to one node before the node to be deleted.
        //So, delete the link first is pointing to now.
        first.next = first.next.next;

        printList(head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}