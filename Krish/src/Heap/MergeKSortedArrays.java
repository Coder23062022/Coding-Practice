package Krish.src.Heap;

//Problem: https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
//Video source: https://www.youtube.com/watch?v=ptYUCjfNhJY&ab_channel=BackToBackSWE
//Time Complexity: O(klogk) + O(n * k * logk), <For while loop, k arrays each of size n, so n * k and logk for pq operations>
//Space Complexity: O(k)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class Node {
        int val, row, col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 3;
        System.out.println(mergeKArrays(arr, k));
    }

    static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 0));
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            res.add(curr.val);
            int nextCol = curr.col + 1;
            if (nextCol < k) {
                pq.add(new Node(arr[curr.row][nextCol], curr.row, nextCol));
            }
        }
        return res;
    }
}