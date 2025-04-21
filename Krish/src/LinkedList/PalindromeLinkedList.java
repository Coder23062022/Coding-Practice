package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/palindrome-linked-list/
//Video source: https://www.youtube.com/watch?v=ee-DuKtRNGw&ab_channel=AnujBhaiya
//Time complexity: O(n)
//Space complexity: O(1)

public class PalindromeLinkedList {
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
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        System.out.println("It's a palindrome Linked list: ");
        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node mid = middle(head); //Find the middle element.
        Node last = reverse(mid); //Reverse the second half of the list. last is pointing to the head of the reverse part.

        //Verify the nodes are same in both the halves.
        while (last != null) {
            if (head.data != last.data) {
                return false;
            }
            head = head.next;
            last = last.next;
        }
        return true;
    }

    static Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node reverse(Node node) {
        Node curr = node;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
}