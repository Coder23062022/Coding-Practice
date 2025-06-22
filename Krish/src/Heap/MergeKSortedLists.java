package Krish.src.Heap;

//Problem: https://leetcode.com/problems/merge-k-sorted-lists/
//Video source: https://www.youtube.com/watch?v=1zktEppsdig&ab_channel=takeUforward
//Time Complexity: O(klogk) + (n * k * logk) <For while loop, k lists each of size n, so n * k and logk for pq operations>
//Space Complexity: O(k)

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Method to insert a node at the end of the linked list
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    //Method to print linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        /*
         * Let's create three sorted linked lists.
         * llist1: 1->4->5, llist2: 1->3->4, llist3: 2->6
         */
        MergeKSortedLists llist1 = new MergeKSortedLists();
        MergeKSortedLists llist2 = new MergeKSortedLists();
        MergeKSortedLists llist3 = new MergeKSortedLists();

        llist1.addToTheLast(new Node(1));
        llist1.addToTheLast(new Node(4));
        llist1.addToTheLast(new Node(5));

        llist2.addToTheLast(new Node(1));
        llist2.addToTheLast(new Node(3));
        llist2.addToTheLast(new Node(4));

        llist3.addToTheLast(new Node(2));
        llist3.addToTheLast(new Node(6));

        int k = 3;
        Node[] lists = new Node[k];
        lists[0] = llist1.head;
        lists[1] = llist2.head;
        lists[2] = llist3.head;

        llist1.head = mergeKLists(lists);
        llist1.printList();
    }

    static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.data));
        for (Node head : lists) {
            if (head != null) pq.add(head);
        }

        Node dummyNode = new Node(-1);
        Node result = dummyNode;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result.next = node;
            result = result.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummyNode.next;
    }
}