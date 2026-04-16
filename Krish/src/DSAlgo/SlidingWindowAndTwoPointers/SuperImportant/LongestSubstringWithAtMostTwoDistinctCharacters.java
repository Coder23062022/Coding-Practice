package Krish.src.DSAlgo.SlidingWindowAndTwoPointers.SuperImportant;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
//Solution: https://www.geeksforgeeks.org/dsa/longest-substring-with-at-most-two-distinct-characters/
//Time complexity: O(n)
//Space complexity: O(n)

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 2;
        System.out.println(longestSubstr(s, k));
    }

    static int longestSubstr(String s, int k) {
        int l = 0, r = 0, maxLen = -1;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}