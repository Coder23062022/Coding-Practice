package Krish.src.Tree;

//Problem: https://www.geeksforgeeks.org/problems/largest-bst/1
//Video source: https://www.youtube.com/watch?v=X0oXMdtUDwo&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=53&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class LargestBSTInABinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(2);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        System.out.println(largestBst(root));
    }

    static class NodeValue {
        int minNode;
        int maxNode;
        int size;

        NodeValue(int minNode, int maxNode, int size) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.size = size;
        }
    }

    static int largestBst(TreeNode root) {
        return largestBstHelper(root).size;
    }

    static NodeValue largestBstHelper(TreeNode root) {
        if (root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        if (left.maxNode < root.data && root.data < right.minNode) {
            return new NodeValue(Math.min(left.minNode, root.data), Math.max(right.maxNode, root.data), 1 + left.size + right.size);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
}