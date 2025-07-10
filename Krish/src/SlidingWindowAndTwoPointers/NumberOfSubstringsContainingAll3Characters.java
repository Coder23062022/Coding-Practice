package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
//Video source: https://www.youtube.com/watch?v=xtqN4qlgr8s&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=7&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

import java.util.stream.IntStream;

public class NumberOfSubstringsContainingAll3Characters {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    static int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            count = count + (1 + IntStream.of(lastSeen).min().getAsInt());
        }
        return count;
    }
}