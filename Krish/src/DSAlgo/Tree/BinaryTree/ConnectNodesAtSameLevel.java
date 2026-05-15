package Krish.src.DSAlgo.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//Problem: https://www.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
//Time complexity: O(n)
//Space complexity: O(n)

public class ConnectNodesAtSameLevel {
    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int key) {
            data = key;
            left = right = nextRight = null;
        }
    }

    public static void main(String[] args) {
        // Constructed binary tree
        //       10
        //      /  \
        //    8     2
        //   /     /
        //  3     4

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.left = new Node(4);

        connect(root);

        System.out.println("Next Right of 8 is " + root.left.nextRight.data);
        System.out.println("Next Right of 3 is " + root.left.left.nextRight.data);
    }

    // Connect nodes using node count (level size)
    static Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                // Set nextRight
                if (i == size - 1) //For the last node in the group, set the next to null
                    node.nextRight = null;
                else
                    //Otherwise, set next to the immediate next val which is in the queue top
                    node.nextRight = q.peek();

                // Push children
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return root;
    }
}