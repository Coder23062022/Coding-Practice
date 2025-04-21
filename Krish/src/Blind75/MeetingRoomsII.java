package Krish.src.Blind75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Problem: https://www.lintcode.com/problem/919/
//Video reference: https://www.youtube.com/watch?v=dxVcMDI7vyI&ab_channel=takeUforward
//Time Complexity: O(2nlogn) + O(n) //To sort both the arrays it takes O(2nlogn). To traverse both the arrays it takes O(n).
//Space complexity: O(1)
//Solution approach: Similar to MinNoOfPlatformsNeeded problem

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
//        List<Interval> intervals = Arrays.asList(new Interval(2, 7));
        List<Interval> intervals = Arrays.asList(new Interval(1, 5), new Interval(5, 10), new Interval(10, 15), new Interval(15, 20));
        System.out.println(minMeetingRooms(intervals, intervals.size()));
    }

    static int minMeetingRooms(List<Interval> intervals, int n) {
        if (n == 0) return 0;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int meetingRoomsNeeded = 1, result = 1, i = 1, j = 0;
        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                meetingRoomsNeeded++;
                i++;
            } else {
                meetingRoomsNeeded--;
                j++;
            }
            result = Math.max(result, meetingRoomsNeeded);
        }
        return result;
    }
}