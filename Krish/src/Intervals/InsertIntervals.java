package Krish.src.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/insert-interval
//Video source: https://www.youtube.com/watch?v=xxRE-46OCC8&ab_channel=takeUforward
//Time Complexity: O(n)
//Space complexity: O(n), considering the result array

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        for (int[] interval : insert(intervals, newInterval))
            System.out.println(Arrays.toString(interval));
    }

    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        //All the non-overlapping intervals of the left side
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i = i + 1;
        }

        //All the overlapping intervals in the middle. Take the minimum value of start point and maximum value of end point.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i = i + 1;
        }
        result.add(newInterval);

        //All the non-overlapping intervals of the right side
        while (i < n) {
            result.add(intervals[i]);
            i = i + 1;
        }

        return result.toArray(new int[result.size()][]);
    }
}