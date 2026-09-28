package Krish.src.DSAlgo.Tree.BinaryTree.SuperImportant;

import java.util.ArrayList;

//Problem: https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
//Video source: https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=26&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(h), height of the binary tree

public class PathFromRootToAGivenNodeInABinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x = 5;
        printPath(root, x);
    }

    static void printPath(Node root, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        if (hasPath(root, res, x)) {
            for (int i = 0; i < res.size() - 1; i++)
                System.out.print(res.get(i) + "->");
            System.out.print(res.get(res.size() - 1));
        } else
            System.out.print("No Path");
    }

    static boolean hasPath(Node root, ArrayList<Integer> res, int x) {
        if (root == null) return false;
        res.add(root.data);
        if (root.data == x) return true;
        if (hasPath(root.left, res, x) || hasPath(root.right, res, x)) return true;
        res.remove(res.size() - 1);
        return false;
    }
}