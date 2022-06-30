package src.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = {{1,2},{1,2},{1,2}};
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); //sort by end time.
        int count = 0;
        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (currEnd <= intervals[i][0]) {
                currEnd = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}