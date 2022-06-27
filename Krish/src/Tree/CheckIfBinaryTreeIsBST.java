package src.Tree;

public class CheckIfBinaryTreeIsBST {
    static BST root;
    static BST l;
    static BST r;

    static class BST {
        int data;
        BST left, right;

        public BST(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        root = new BST(10);
        root.left = new BST(10);
        root.right = new BST(19);
        root.left.left = new BST(-5);
        root.right.left = new BST(17);
        root.right.right = new BST(21);
        System.out.println(isBST(root, l, r));
    }

    //source video: https://www.youtube.com/watch?v=MILxfAbIhrE&ab_channel=TusharRoy-CodingMadeSimple
    static boolean isBST(BST root, BST l, BST r) {
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