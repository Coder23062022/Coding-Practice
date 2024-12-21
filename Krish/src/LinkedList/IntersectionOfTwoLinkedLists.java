package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
//Time complexity: O(m + n)
//Space complexity: O(1)

public class IntersectionOfTwoLinkedLists {
    static Node headA;
    static Node headB;

    static class Node {
        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        headA = new Node("a1");
        headA.next = new Node("a2");
        headA.next.next = new Node("c1");
        headA.next.next.next = new Node("c2");
        headA.next.next.next.next = new Node("c3");

        headB = new Node("b1");
        headB.next = new Node("b2");
        headB.next.next = new Node("b3");
        headB.next.next.next = new Node("c1");
        headB.next.next.next.next = new Node("c2");
        headB.next.next.next.next.next = new Node("c3");

        System.out.println("Intersection node of the two linked lists is: ");
        System.out.println(getIntersectionNode(headA, headB));
    }

    static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        Node a = headA;
        Node b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a; //You can return b also here.
    }
}