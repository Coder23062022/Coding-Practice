package Krish.src.Tree;

//Problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//Video source: https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=30&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode target = root.left;
        int k = 2;
        System.out.println(distanceK(root, target, k));
    }

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target, true);
        int curr_level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (curr_level == k) break;
            curr_level++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && visited.get(curr.left) == null) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && visited.get(curr.right) == null) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }

                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().data);
        }
        return res;
    }

    static void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
}