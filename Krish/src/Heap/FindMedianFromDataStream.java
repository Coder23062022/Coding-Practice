package Krish.src.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//Problem: https://leetcode.com/problems/find-median-from-data-stream/
//Video source: https://www.youtube.com/watch?v=itmhHWaHupI&t=987s&ab_channel=NeetCode
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class FindMedianFromDataStream {
    static PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8};
        ArrayList<Double> res = getMedian(arr);
        System.out.printf("%.2f", res.get(0));

        for (int i = 1; i < res.size(); i++) {
            System.out.printf(" %.2f", res.get(i));
        }
    }

    static ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> res = new ArrayList<>();
        for (int j : arr) {
            leftMaxHeap.add(j);
            rightMinHeap.add(leftMaxHeap.poll());
            if (rightMinHeap.size() > leftMaxHeap.size()) {
                leftMaxHeap.add(rightMinHeap.poll());
            }

            double median;
            if (leftMaxHeap.size() != rightMinHeap.size())
                median = leftMaxHeap.peek();
            else
                median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;

            res.add(median);
        }
        return res;
    }

    static void addNum(int num) {
        leftMaxHeap.add(num);
        rightMinHeap.add(leftMaxHeap.poll());
        if (rightMinHeap.size() > leftMaxHeap.size()) leftMaxHeap.add(rightMinHeap.poll());
    }

    static double findMedian() {
        if (leftMaxHeap.size() != rightMinHeap.size())
            return leftMaxHeap.peek();
        else
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
    }
}