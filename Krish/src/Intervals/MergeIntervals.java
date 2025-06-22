package Krish.src.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Problem: https://leetcode.com/problems/merge-intervals/
//Video source: https://www.youtube.com/watch?v=IexN60k62jo&t=635s&ab_channel=takeUforward
//Time Complexity: O(nlogn) + O(n)
//Space complexity: O(n), to store the ans

public class MergeIntervals {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 3}, {2, 6}, {4, 5}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1,4},{5,6}};
        for (int[] interval : merge(intervals))
            System.out.println(Arrays.toString(interval));
    }

    static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) { //This means it's overlapping.
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}