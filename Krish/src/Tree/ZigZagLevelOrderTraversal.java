package Krish.src.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//Video source: https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=19&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class ZigZagLevelOrderTraversal {
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
        List<List<Integer>> result = zigzagLevelOrderTraversal(root);
        for (List<Integer> nodes : result) {
            System.out.println(nodes);
        }
    }

    static List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentList.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            if (flag == 0) {
                result.add(currentList);
                flag = 1;
            } else {
                Collections.reverse(currentList);
                result.add(currentList);
                flag = 0;
            }

        }
        return result;
    }
}