package Krish.src.DSAlgo.Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Problem: https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
//Video source: https://www.youtube.com/watch?v=mKfhTotEguk
//Time Complexity: O(nlogn) + O(n)
//Space complexity: O(n)

public class MaximumMeetingsInOneRoom {
    static class Pair {
        int start;
        int end;
        int index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        List<Pair> meetings = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            meetings.add(new Pair(s[i], f[i], i + 1));
        }

        meetings.sort(Comparator.comparingInt(a -> a.end));

        int currEnd = -1;

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            if (meetings.get(i).start > currEnd) { //no overlap
                res.add(meetings.get(i).index);
                currEnd = meetings.get(i).end;
            }
        }

        Collections.sort(res);
        return res;
    }

    static void main() {
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] f = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(s, f));
    }
}