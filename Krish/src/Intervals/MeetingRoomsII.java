package src.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Problem: https://www.lintcode.com/problem/919/

public class MeetingRoomsII {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
//        List<Interval> intervals = Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        List<Interval> intervals = Arrays.asList(new Interval(2, 7));
        System.out.println(minMeetingRooms(intervals));
    }

    static int minMeetingRooms(List<Interval> intervals) {
        int minMeetingRoomsNeeded = 1, result = 1;
        int i = 1, j = 0;
        intervals.sort(Comparator.comparingInt(a -> a.start));
        intervals.sort(Comparator.comparingInt(a -> a.end));

        while (i < intervals.size() && j < intervals.size()) {
            if (intervals.get(i).start <= intervals.get(j).end) {
                minMeetingRoomsNeeded++;
                i++;
            } else {
                minMeetingRoomsNeeded--;
                j++;
            }
            result = Math.max(result, minMeetingRoomsNeeded);
        }
        return result;
    }
}
