package Krish.src.Tree;

//Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//Video source: https://www.youtube.com/watch?v=12omz-VAyRk&ab_channel=NickWhite
//Time complexity: O(logn)
//Space complexity: O(n)

public class ConvertSortedArrayToBST {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        printTreePreorder(sortedArrayToBST(nums));
    }

    static void printTreePreorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printTreePreorder(root.left);
        printTreePreorder(root.right);
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return constructBST(nums, 0, nums.length - 1);
    }

    static TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, left, mid - 1);
        node.right = constructBST(nums, mid + 1, right);
        return node;
    }
}