package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/longest-repeating-character-replacement
//Video source: https://www.youtube.com/watch?v=_eNhaDCr6P0&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(26)

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, maxF = 0, wl, maxLen = 0;

        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            wl = r - l + 1;
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            //If (wl-maxF > k), then we have to increase the left pointer to shrink the window.
            //wl-maxF = number of characters need to be replaced
            if (wl - maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                wl = r - l + 1;
            }
            maxLen = Math.max(maxLen, wl);
            r++;
        }
        return maxLen;
    }
}