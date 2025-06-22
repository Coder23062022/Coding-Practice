package Krish.src.Tree;

//Problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
//Video source: https://www.youtube.com/watch?v=7cp5imvDzl4&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(n)

public class CountGoodNodesInBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(goodNodes(root));
    }

    static int goodNodes(TreeNode root) {
        int[] count = new int[1];
        goodNodes(root, count, Integer.MIN_VALUE);
        return count[0];
    }

    static void goodNodes(TreeNode node, int[] count, int max) {
        if (node == null) return;
        if (node.data >= max) count[0]++;
        max = Math.max(max, node.data);
        goodNodes(node.left, count, max);
        goodNodes(node.right, count, max);
    }
}