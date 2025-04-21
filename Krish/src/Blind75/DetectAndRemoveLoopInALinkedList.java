package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/linked-list-cycle/description/
//Video source: https://www.youtube.com/watch?v=wiOo4DC5GGA&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

class DetectAndRemoveLoopInALinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Function that detects loop in the list
    void detectAndRemoveLoop(Node node) {
        //If list is empty or has only one node without loop
        if (node == null || node.next == null)
            return;

        //Move slow and fast 1 and 2 steps ahead respectively.
        Node slow = node, fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        //If loop exists, then how to remove the loop
        Node prev = null;
        if (slow == fast) {
            slow = node; //Starting slow from the first node.
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }

        //Since fast->next is the looping point
        prev.next = null; //Remove loop
    }

    //Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DetectAndRemoveLoopInALinkedList list = new DetectAndRemoveLoopInALinkedList();
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        // Test case 2
//		head = new Node(1);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = head;

        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}