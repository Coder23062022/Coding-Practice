package src.LinkedList;

//Time Complexity:  Since we are traversing through the two lists fully. So, the time complexity is O(m+n) where m and n are the lengths of the 
//two lists to be merged. 
class MergeTwoSortedLists {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to insert a node at the end of the linked list
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

    /* Method to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        /*
         * Let us create two sorted linked lists to test the methods Created lists:
         * llist1: 5->10->15, llist2: 2->3->20
         */
        MergeTwoSortedLists llist1 = new MergeTwoSortedLists();
        MergeTwoSortedLists llist2 = new MergeTwoSortedLists();

        llist1.addToTheLast(new Node(5));
        llist1.addToTheLast(new Node(10));
        llist1.addToTheLast(new Node(15));

        llist2.addToTheLast(new Node(2));
        llist2.addToTheLast(new Node(3));
        llist2.addToTheLast(new Node(20));

//        llist1.head = sortedMerge(llist1.head, llist2.head);
        llist1.head = sortedMergeWithoutRecursion(llist1.head, llist2.head);
        llist1.printList();
    }

    static Node sortedMerge(Node A, Node B) {
        if (A == null)
            return B;
        if (B == null)
            return A;

        if (A.data < B.data) {
            A.next = sortedMerge(A.next, B);
            return A;
        } else {
            B.next = sortedMerge(A, B.next);
            return B;
        }
    }

    static Node sortedMergeWithoutRecursion(Node A, Node B) {
        //Source: https://www.youtube.com/watch?v=K63Mjf-H0B0
        Node result = new Node(-1);
        Node head = result;
        while (A != null && B != null) {
            if (A.data < B.data) {
                result.next = A; //If element in A list is smaller, then add it to the result list and go to next element in A list.
                A = A.next;
            } else {
                result.next = B; //If element in B list is smaller, then add it to the result list and go to next element in B list.
                B = B.next;
            }
            result = result.next; //Forward the result list pointer.
        }

        //If there are any extra elements in any of the lists, then append them to the result list.
        if (A != null) {
            result.next = A;
        } else {
            result.next = B;
        }
        return head.next; //Return the result list.
    }
}