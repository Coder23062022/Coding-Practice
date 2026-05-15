package Krish.src.DSAlgo.Tree.BinaryTree;

//Problem: https://leetcode.com/problems/maximum-width-of-binary-tree/
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println("Maximum width of the binary tree is: " + widthOfBinaryTreeMethod1(root));
    }

    //Video source: https://www.youtube.com/watch?v=rhz-csskg_A
    static class Pair1 {
        TreeNode node;
        long index;

        Pair1(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    static int widthOfBinaryTreeMethod1(TreeNode root) {
        int maxWidth = 0;
        Deque<Pair1> q = new LinkedList<>();
        q.add(new Pair1(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            long stIdx = q.peekFirst().index;
            long endIdx = q.peekLast().index;
            maxWidth = Math.max(maxWidth, (int) (endIdx - stIdx + 1));


            for (int i = 0; i < size; i++) {
                Pair1 curr = q.poll();
                TreeNode node = curr.node;
                long index = curr.index;
                if (node.left != null) q.add(new Pair1(node.left, 2 * index + 1));
                if (node.right != null) q.add(new Pair1(node.right, 2 * index + 2));
            }
        }
        return maxWidth;
    }

    //Video source: https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=28&ab_channel=takeUforward
    static class Pair2 {
        TreeNode node;
        int index;

        Pair2(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    static int widthOfBinaryTreeMethod2(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().index;
            int fast = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int curr_idx = q.peek().index - min;
                if (i == 0) fast = curr_idx;
                if (i == size - 1) last = curr_idx;

                TreeNode curr = q.peek().node;
                q.poll();

                if (curr.left != null) {
                    q.add(new Pair2(curr.left, 2 * curr_idx + 1));
                }

                if (curr.right != null) {
                    q.add(new Pair2(curr.right, 2 * curr_idx + 2));
                }
            }
            ans = Math.max(ans, last - fast + 1);
        }
        return ans;
    }
}