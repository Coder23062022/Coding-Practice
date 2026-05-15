package Krish.src.DSAlgo.Tree.BinarySearchTree;

import java.util.Stack;

//Problem: https://leetcode.com/problems/binary-search-tree-iterator
//Video source: https://www.youtube.com/watch?v=D2jMcmxU4bs
//Time complexity: O(1)
//Space complexity: O(h)

public class BinarySearchTreeIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        new BinarySearchTreeIterator(root);

        System.out.println(next());
        System.out.println(next());
        System.out.println(hasNext());
        System.out.println(next());
        System.out.println(hasNext());
        System.out.println(next());
        System.out.println(hasNext());
        System.out.println(next());
        System.out.println(hasNext());
    }

    static Stack<TreeNode> st = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    static int next() {
        TreeNode curr = st.pop();
        pushAll(curr.right);
        return curr.val;
    }

    static boolean hasNext() {
        return !st.isEmpty();
    }

    static void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}