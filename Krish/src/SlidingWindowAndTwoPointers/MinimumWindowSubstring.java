package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/minimum-window-substring/
//Video source: https://www.youtube.com/watch?v=WJaij9ffOIY&ab_channel=takeUforward
//Time complexity: O(2n) + O(m), where n and m are the length of string s and t respectively
//Space complexity: O(256)

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindowUsingHashMap(s, t));
    }

    static String minWindowUsingHashMap(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, sIdx = -1, count = 0;

        //Fill the map with the character frequencies of t string
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        //Run the sliding window for s string
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0) count++;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);

            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIdx = l;
                }
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                if (map.get(s.charAt(l)) > 0) count--;
                l++;
            }
            r++;
        }
        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLen);
    }

    static String minWindowUsingArray(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n) return "";

        int l = 0, r = 0, minLength = Integer.MAX_VALUE, startIdx = -1, count = 0;

        int[] chars = new int[256];
        for (int i = 0; i < m; i++) {
            chars[t.charAt(i)]++;
        }

        while (r < n) {
            if (chars[s.charAt(r)] > 0) count++;
            chars[s.charAt(r)]--;

            while (count == m) {
                int currentLength = r - l + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    startIdx = l;
                }
                chars[s.charAt(l)]++;
                if (chars[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }
}