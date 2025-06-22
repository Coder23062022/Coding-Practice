package Krish.src.Tree;

//Problem: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
//Video source: https://www.youtube.com/watch?v=q_a6lpbKJdw&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=21&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(h), height of the binary tree

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
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
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        for (List<Integer> nodes : verticalTraversal(root)) {
            System.out.print(nodes + ",");
        }
    }

    static class Tuple {
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }

            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            map.get(vertical).get(level).add(node.data);

            if (node.left != null) {
                q.add(new Tuple(node.left, vertical - 1, level + 1));
            }

            if (node.right != null) {
                q.add(new Tuple(node.right, vertical + 1, level + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> entry : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : entry.values()) {
                while (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }
        return res;
    }
}