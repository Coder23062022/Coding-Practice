package src.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1,4},{5,6}};
        for (int[] interval : merge(intervals))
            System.out.println(Arrays.toString(interval));
    }

    static int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();

        if (intervals.length != 0) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int[] i : intervals) {
                if (i[0] <= end) {
                    end = Math.max(end, i[1]);
                } else {
                    answer.add(new int[]{start, end});
                    start = i[0];
                    end = i[1];
                }
            }
            answer.add(new int[]{start, end});
        }
        return answer.toArray(new int[0][]);
    }
}
