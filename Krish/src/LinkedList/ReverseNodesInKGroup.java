package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
//Source video: https://www.youtube.com/watch?v=fi2vh0nQLi0&t=492s&ab_channel=CodeHelp-byBabbar
//Source video: https://www.youtube.com/watch?v=lIar1skcQYI
//Time Complexity: O(n)
//Space Complexity: O(n/k), if we use recursive approach. For iterative approach, it will be O(1).

public class ReverseNodesInKGroup {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int k = 3;
        System.out.println("Linkedlist before reverse:");
        printList(head);
        System.out.println("\nLinkedlist after reverse:");
        printList(reverseKGroupIterative(head, k));
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static Node reverseKGroupRecursive(Node head, int k) {
        if (head == null || head.next == null) return head;

        //Length of the linked list
        Node temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        //Reverse first k nodes of linked list
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        int remainingNodesCount = length - count;
        if (next != null && remainingNodesCount >= k) {
            head.next = reverseKGroupRecursive(next, k);
        } else {
            head.next = next; //Append the remaining nodes to the end
        }

        // prev is now head of input list
        return prev;
    }

    static Node reverseKGroupIterative(Node head, int k) {
        //Initialize a temporary node to traverse the list
        Node temp = head;

        //Initialize a pointer to track the last node of the previous group
        Node prevLast = null;

        //Traverse through the linked list
        while (temp != null) {
            //Get the Kth node of the current group
            Node kThNode = getKthNode(temp, k);

            //If the Kth node is NULL (not a complete group)
            if (kThNode == null) {
                //If there was a previous group, link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                //Exit the loop
                break;
            }

            //Store the next node after the Kth node
            Node nextNode = kThNode.next;

            //Disconnect the Kth node to prepare for reversal
            kThNode.next = null;

            //Reverse the nodes from temp to the Kth node
            reverseLinkedList(temp);

            //Adjust the head if the reversal starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                //Link the last node of the previous group to the reversed group
                prevLast.next = kThNode;
            }

            //Update the pointer to the last node of the previous group
            prevLast = temp;

            //Move to the next group
            temp = nextNode;
        }

        //Return the head of the modified linked list
        return head;
    }

    static void reverseLinkedList(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    static Node getKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
}