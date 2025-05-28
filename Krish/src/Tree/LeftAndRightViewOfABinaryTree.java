package Krish.src.Tree;

//Problem: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
//Problem: https://leetcode.com/problems/binary-tree-right-side-view/
//Video source: https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=24&ab_channel=takeUforward
//Time Complexity: O(n), where n is the number of nodes in the binary tree.
//Space complexity: O(h), height of the binary tree (worst case for skewed tree)

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;

public class LeftAndRightViewOfABinaryTree {
    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        List<Integer> res1 = new ArrayList<>();
        System.out.println("Left view of the tree:");
        printLeftView(root, 0, res1);
        System.out.println(res1);

        List<Integer> res2 = new ArrayList<>();
        System.out.println("\nRight view of the tree:");
        printRightView(root, 0, res2);
        System.out.println(res2);
    }

    static void printLeftView(Node node, int level, List<Integer> res) {
        if (node == null) return;
        if (level == res.size()) res.add(node.data);
        printLeftView(node.left, level + 1, res);
        printLeftView(node.right, level + 1, res);
    }

    static void printRightView(Node node, int level, List<Integer> res) {
        if (node == null) return;
        if (level == res.size()) res.add(node.data);
        printRightView(node.right, level + 1, res);
        printRightView(node.left, level + 1, res);
    }
}