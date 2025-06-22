package Krish.src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//Video source: https://www.youtube.com/watch?v=ZdDs2ps7rEs&ab_channel=CodingSimplified
//Time complexity: O(n)
//Space complexity: O(n)

public class PopulatingNextRightPointersInEachNode {
    static class Node {
        int data;
        Node left, right, next;

        Node(int d) {
            data = d;
            this.left = this.right = this.next = null;
        }
    }

    public static void main(String[] args) {
        // Constructed binary tree is
        //       10
        //      /  \
        //    8     2
        //   /        \
        //  3          90

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        connect(root);
        List<String> output = getNextRightList(root);
        System.out.println(String.join(" ", output));
    }

    static void connect(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr != null) {
                curr.next = q.peek();
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            } else if (!q.isEmpty()) { //It means end of that level (Because curr == null but queue is not empty)
                q.add(null);
            }
        }
    }

    static List<String> getNextRightList(Node root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr != null) {
                result.add(Integer.toString(curr.data));

                if (curr.next == null) {
                    result.add("#");
                }

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
        return result;
    }
}