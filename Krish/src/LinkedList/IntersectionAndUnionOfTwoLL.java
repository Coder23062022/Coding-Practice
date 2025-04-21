package Krish.src.LinkedList;

import java.util.HashSet;

//Video source: https://www.youtube.com/watch?v=2DZL9Ogm1Cg&ab_channel=GeeksforGeeks
//Related doc: https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-hashing/
//Time complexity: O(m+n) , where m and n are number of elements present in first and second lists respectively.
//Space complexity: O(m+n)

public class IntersectionAndUnionOfTwoLL {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);

        // List 2: 1 -> 5 -> 6
        Node head2 = new Node(1);
        head2.next = new Node(5);
        head2.next.next = new Node(6);

        printUnionIntersection(head1, head2);
    }

    static void printUnionIntersection(Node head1, Node head2) {
        Node intersectionList = getIntersection(head1, head2);
        Node unionList = getUnion(head1, head2);

        System.out.println("Intersection list is:");
        printList(intersectionList);

        System.out.println("Union list is:");
        printList(unionList);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node getIntersection(Node head1, Node head2) {
        HashSet<Integer> hs = new HashSet<>();
        Node result = null;

        Node n1 = head1;
        while (n1 != null) {
            hs.add(n1.data);
            n1 = n1.next;
        }

        Node n2 = head2;
        while (n2 != null) {
            if (hs.contains(n2.data)) {
                Node newNode = new Node(n2.data);
                newNode.next = result;
                result = newNode;
            }
            n2 = n2.next;
        }
        return result;
    }

    static Node getUnion(Node head1, Node head2) {
        HashSet<Integer> hs = new HashSet<>();
        Node result = null;

        Node n1 = head1;
        while (n1 != null) {
            hs.add(n1.data);
            n1 = n1.next;
        }

        Node n2 = head2;
        while (n2 != null) {
            hs.add(n2.data);
            n2 = n2.next;
        }

        for (Integer data : hs) {
            Node newNode = new Node(data);
            newNode.next = result;
            result = newNode;
        }
        return result;
    }
}