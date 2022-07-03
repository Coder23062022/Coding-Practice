package src.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(0, 3), new Interval(5, 10), new Interval(15, 20));
        System.out.println("Can Attend All Meetings? - " + canAttendMeetings(intervals));
    }

    static boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) return false;
        }
        return true;
    }
}
