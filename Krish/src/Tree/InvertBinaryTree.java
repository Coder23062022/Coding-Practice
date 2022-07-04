package src.Tree;

public class InvertBinaryTree {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static void printTreeInorder(TreeNode root) {
        if (root == null)
            return;
        printTreeInorder(root.left);
        System.out.print(root.data + " ");
        printTreeInorder(root.right);
    }

    public static void main(String[] args) {
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println("Tree before inversion: ");
        printTreeInorder(root);
        System.out.println("\nTree after inversion: ");
        printTreeInorder(invertTree(root));
    }

    static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
