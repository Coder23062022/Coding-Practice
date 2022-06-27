package src.Tree;

public class SameTreeCheck {
    static TreeNode root1;
    static TreeNode root2;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);

        System.out.println(sameTreeCheck(root1, root2));
    }

    static boolean sameTreeCheck(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.data != q.data)
            return false; //If at any recursive call, value is not matched, then both are not same tree.
        return sameTreeCheck(p.left, q.left) && sameTreeCheck(p.right, q.right);
    }
}
