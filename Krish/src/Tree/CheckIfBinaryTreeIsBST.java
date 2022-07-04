package src.Tree;

public class CheckIfBinaryTreeIsBST {
    static TreeNode root;
    static TreeNode l;
    static TreeNode r;

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(10);
        root.left = new TreeNode(10);
        root.right = new TreeNode(19);
        root.left.left = new TreeNode(-5);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(21);
        System.out.println(isBST(root, l, r));
    }

    //source video: https://www.youtube.com/watch?v=MILxfAbIhrE&ab_channel=TusharRoy-CodingMadeSimple
    static boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
        //An empty tree is considered to be a BST.
        if (root == null)
            return true;
        //In a BST, root value should be greater than its left subtree and lesser than it's right subtree.
        //l and r are here taken as left and right boundaries just like we do in binary search.
        if (l != null && root.data <= l.data || r != null && root.data >= r.data)
            return false;

        return isBST(root.left, l, root) && isBST(root.right, root, r);
    }
}