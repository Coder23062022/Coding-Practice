package src.LinkedList;

public class ReverseListInGroupOfGivenSize {
    static Node head;
    static Temp tempHead;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Temp {
        int data;
        Temp next;

        Temp(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        push(8);
        push(7);
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);
        reverseByK(head, k);
    }

    static void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    static void reverseByK(Node node, int k) {
        while (node != null) {
            int index = 0;
            for (int i = index; i < k && node != null; i++) {
                int d = node.data;
                node = node.next;

                Temp new_node = new Temp(d);
                new_node.next = tempHead;
                tempHead = new_node;

                index++;
            }
            while (tempHead != null) {
                System.out.print(tempHead.data + " ");
                tempHead = tempHead.next;
            }
        }
    }
}