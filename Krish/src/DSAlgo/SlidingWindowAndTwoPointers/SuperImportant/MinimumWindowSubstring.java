package Krish.src.DSAlgo.SlidingWindowAndTwoPointers.SuperImportant;

//Problem: https://leetcode.com/problems/minimum-window-substring/
//Video source: https://www.youtube.com/watch?v=WJaij9ffOIY&ab_channel=takeUforward
//Time complexity: O(2n) + O(m), where n and m are the length of string s and t respectively
//Space complexity: O(256)

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    static void main() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindowUsingHashMap(s, t));
    }

    static String minWindowUsingHashMap(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0, minLen = Integer.MAX_VALUE, startIndex = -1, l = 0, r = 0;

        while (r < s.length()) {
            if (freqMap.containsKey(s.charAt(r)) && freqMap.get(s.charAt(r)) > 0) { //If its pre-inserted
                count++;
            }

            freqMap.put(s.charAt(r), freqMap.getOrDefault(s.charAt(r), 0) - 1); //Decrement the char freq while expanding

            //Shrink the window till count matches t length to find the minimum window
            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }

                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) + 1); //Increment the char freq while shrinking
                if (freqMap.get(s.charAt(l)) > 0)
                    count--; //If char freq becomes positive, decrement the count to break the loop
                l++;
            }

            r++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
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