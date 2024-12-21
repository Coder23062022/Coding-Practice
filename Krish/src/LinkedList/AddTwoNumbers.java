package Krish.src.LinkedList;

//Problem: https://leetcode.com/problems/add-two-numbers/
//Time complexity: O(n)
//Space complexity: O(n)

public class AddTwoNumbers {
    static Node headA;
    static Node headB;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        headA = new Node(2);
        headA.next = new Node(4);
        headA.next.next = new Node(3);

        headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(4);

        System.out.println("New linked list is: ");
        Node curr = addTwoNumbers(headA, headB);
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0); // creating a dummy list
        Node curr = dummy; // initialising a pointer
        int carry = 0;
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it. 
        // We will add that as well into our list
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) { // adding l1 to our sum & moving l1
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) { // adding l2 to our sum & moving l2
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum / 10; // if we get carry, then divide it by 10 to get the carry
            curr.next = new Node(sum % 10); // the value we'll get by moduling it, will become as new node. So, add it to our list. curr will point to that new node we get
            curr = curr.next; // update the current every time
        }
        return dummy.next; // return dummy.next bcz, we don't want the value we have considered in it initially.
    }
}
