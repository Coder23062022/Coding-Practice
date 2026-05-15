package Krish.src.DSAlgo.Tree.BinaryTree;

//Problem: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
//Video source: https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=20&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalOfABinaryTree {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Diameter of the binary tree is: " + boundaryTraversal(root));
    }

    static List<Integer> boundaryTraversal(TreeNode node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isLeaf(node)) res.add(node.data);
        leftBoundary(node.left, res);
        leafNodes(node, res);
        rightBoundary(node.right, res);
        return res;
    }

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static void leftBoundary(TreeNode node, ArrayList<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.data);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    static void leafNodes(TreeNode node, ArrayList<Integer> res) {
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }
        if (node.left != null) leafNodes(node.left, res);
        if (node.right != null) leafNodes(node.right, res);
    }

    static void rightBoundary(TreeNode node, ArrayList<Integer> res) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) temp.add(node.data);
            if (node.right != null) node = node.right;
            else node = node.left;
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}