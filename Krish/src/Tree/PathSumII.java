package Krish.src.Tree;

//Problem: https://leetcode.com/problems/path-sum-ii/
//Video source: https://www.youtube.com/watch?v=3B5gnrwRmOA&ab_channel=KevinNaughtonJr.
//Time complexity: O(n)
//Space complexity: O(h)

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int sum = 22;
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        System.out.println(pathSum(root, sum));
    }

    static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    static void pathSum(Node root, int targetSum, List<Integer> currPath, List<List<Integer>> res) {
        if (root == null) return;
        currPath.add(root.data);
        if (root.left == null && root.right == null && root.data == targetSum) res.add(new ArrayList<>(currPath));
        pathSum(root.left, targetSum - root.data, currPath, res);
        pathSum(root.right, targetSum - root.data, currPath, res);
        currPath.remove(currPath.size() - 1);
    }
}