package Krish.src.SlidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

//Problem: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
//Video source: https://www.youtube.com/watch?v=teM9ZsVRQyc&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=6&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }

    static int longestKSubstr(String s, int k) {
        int l = 0, r = 0, maxLen = -1;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }
}