package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/longest-repeating-character-replacement/description/
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
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), 1);
            } else {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            }
            wl = r - l + 1;
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            //If (wl-maxF > k), then we have to increase the left pointer to shrink the window.
            if (wl - maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                wl = r - l + 1;
            }

            //If (wl-maxF <= k), then we are still eligible to replace character. So, we will increase right pointer.
            if (wl - maxF <= k) {
                maxLen = Math.max(maxLen, wl);
                r++;
            }
        }
        return maxLen;
    }
}