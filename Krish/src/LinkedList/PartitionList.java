package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/partition-list/description/
//Video source: https://www.youtube.com/watch?v=KT1iUciJr4g
//Time Complexity: O(n)
//Space Complexity: O(1)
//Note: Same as SegregateEvenAndOddNodes problem

public class PartitionList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);
        ListNode result = partition(listNode, 3);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        ListNode leftTail = leftHead;
        ListNode rightTail = rightHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                leftTail.next = curr;
                leftTail = leftTail.next;
            } else {
                rightTail.next = curr;
                rightTail = rightTail.next;
            }
            curr = curr.next;
        }

        leftTail.next = rightHead.next;
        rightTail.next = null;
        return leftHead.next;
    }
}