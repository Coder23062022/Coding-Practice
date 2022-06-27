package src.Tree;

public class SubTreeOfATree {
    static TreeNode root;
    static TreeNode subRoot;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        subRoot = new TreeNode(7);
        subRoot.left = new TreeNode(6);
        subRoot.right = new TreeNode(9);

        System.out.println(isSubtree(root, subRoot));
    }

    static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (sameTreeCheck(root, subRoot)) return true;
        //Check first in left-subtree if the subTree is present or not, then check in right-subtree.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static boolean sameTreeCheck(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.data != q.data) return false;
        return sameTreeCheck(p.left, q.left) && sameTreeCheck(p.right, q.right);
    }
}
