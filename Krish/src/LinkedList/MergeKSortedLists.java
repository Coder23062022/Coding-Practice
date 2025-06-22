package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/merge-k-sorted-lists/
//Video source: https://www.youtube.com/watch?v=q5a5OiGbT6Q&ab_channel=NeetCode
//Video source: https://www.youtube.com/watch?v=1zktEppsdig&ab_channel=takeUforward
//Note: Two approaches, one with recursion, another with priority queue
//Related article: https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/

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

        llist1.addToTheLast(new MergeKSortedLists.Node(1));
        llist1.addToTheLast(new MergeKSortedLists.Node(4));
        llist1.addToTheLast(new MergeKSortedLists.Node(5));

        llist2.addToTheLast(new MergeKSortedLists.Node(1));
        llist2.addToTheLast(new MergeKSortedLists.Node(3));
        llist2.addToTheLast(new MergeKSortedLists.Node(4));

        llist3.addToTheLast(new MergeKSortedLists.Node(2));
        llist3.addToTheLast(new MergeKSortedLists.Node(6));

        int k = 3;
        Node[] lists = new Node[k];
        lists[0] = llist1.head;
        lists[1] = llist2.head;
        lists[2] = llist3.head;

//        llist1.head = mergeKLists(lists);
        llist1.head = mergeKListsUsingPriorityQueue(lists);
        llist1.printList();
    }

    //Time Complexity: O(n * k * logk)
    //Space Complexity: O(logk), because of recursion
    static Node mergeKLists(Node[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    static Node mergeKListsHelper(Node[] lists, int start, int end) {
        if (start == end) return lists[start]; //If only 1 list is provided.
        if (start + 1 == end) return merge(lists[start], lists[end]); //If only 2 lists are provided.

        int mid = start + (end - start) / 2;
        Node left = mergeKListsHelper(lists, start, mid);
        Node right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    static Node merge(Node l1, Node l2) {
        Node dummyNode = new Node(-1);
        Node result = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        if (l1 != null) {
            result.next = l1;
        } else {
            result.next = l2;
        }
        return dummyNode.next;
    }

    //Using priority queue
    //Time Complexity: O(klogk) + (n * k * logk)
    //Space Complexity: O(k)
    static Node mergeKListsUsingPriorityQueue(Node[] lists) {
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