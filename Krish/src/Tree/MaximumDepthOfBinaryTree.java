package src.Tree;

public class MaximumDepthOfBinaryTree {
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
        System.out.println("Maximum depth of the binary tree is: " + maxDepth(root));
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftSubtreeHeight = maxDepth(root.left);
        int rightSubtreeHeight = maxDepth(root.right);
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }
}
