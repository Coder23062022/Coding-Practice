package Krish.src.DSAlgo.SlidingWindowAndTwoPointers.SuperImportant;

//Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
//Video source: https://www.youtube.com/watch?v=xtqN4qlgr8s
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
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) { //Can remove this condition also
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }
        return count;
    }
}