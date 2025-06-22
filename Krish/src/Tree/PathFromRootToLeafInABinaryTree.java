package Krish.src.Tree;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/binary-tree-paths/
//Video source: https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=26&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(h), height of the binary tree

public class PathFromRootToLeafInABinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(binaryTreePaths(root));
    }

    static List<String> binaryTreePaths(Node root) {
        List<String> res = new ArrayList<>();
        func(root, res, "");
        return res;
    }

    static void func(Node node, List<String> res, String path) {
        if (node == null) return;
        path += node.data;

        if (node.left == null && node.right == null) {
            res.add(path);
        } else {
            path += "->";
            func(node.left, res, path);
            func(node.right, res, path);
        }
    }
}