package Krish.src.DSAlgo.LinkedList.SuperImportant;

//Problem: https://leetcode.com/problems/sort-list/description/
//Video source: https://www.youtube.com/watch?v=8ocB7a_c-Cc
//Time complexity: O(logn * (n + n/2)) = O(nlogn)
//Space complexity: O(logn), for recursive stack space

public class SortList {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int d) {
            val = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(5);
        System.out.println("After sorting linked list is: ");
        printList(sortList(head));
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftHead = head;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeTwoLists(leftHead, rightHead);
    }

    static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                res.next = head1;
                head1 = head1.next;
            } else {
                res.next = head2;
                head2 = head2.next;
            }
            res = res.next;
        }

        if (head1 != null) {
            res.next = head1;
        } else {
            res.next = head2;
        }
        return dummyNode.next;
    }
}