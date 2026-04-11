package Krish.src.Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Problem: https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
//Video source: https://www.youtube.com/watch?v=mKfhTotEguk
//Time Complexity: O(nlogn) + O(n)
//Space complexity: O(n)

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5}, end = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end));
    }

    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int maxMeetings(int[] start, int[] end) {
        List<Pair> meetings = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            meetings.add(new Pair(start[i], end[i]));
        }

        meetings.sort(Comparator.comparingInt(a -> a.end));

        int currEnd = meetings.get(0).end;
        int count = 1;

        for (int i = 1; i < start.length; i++) {
            if (meetings.get(i).start > currEnd) {
                count++;
                currEnd = meetings.get(i).end;
            }
        }

        return count;
    }
}