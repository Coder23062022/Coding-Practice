package Krish.src.SlidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Problem: https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters
//Doc source: https://www.geeksforgeeks.org/dsa/count-k-length-substrings-with-no-repeated-characters/
//Time complexity: O(n)
//Space complexity: O(n)

public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int k = 5;
        System.out.println(countKLenSubstrNoRepeats(s, k));
    }

    static int countKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) return 0;

        int l = 0, r = 0, count = 0;
        Set<Character> hs = new HashSet<>();

        while (r < s.length()) {
            if (!hs.contains(s.charAt(r))) {
                hs.add(s.charAt(r));
                r++;
            } else {
                hs.remove(s.charAt(l));
                l++;
            }

            if (k == hs.size()) {
                count++;
                hs.remove(s.charAt(l));
                l++;
            }
        }
        return count;
    }

    static int countKLenSubstrNoRepeatsMethod2(String S, int K) {
        if (K > S.length()) return 0;

        //Use HashMap to store character frequencies
        Map<Character, Integer> freq = new HashMap<>();
        int count_of_good_lenK_windows = 0;
        int left = 0, right = 0;

        while (right < S.length()) {
            //Add character to frequency map
            freq.put(S.charAt(right), freq.getOrDefault(S.charAt(right), 0) + 1);

            //Step 1: Slide window until no duplicates
            while (freq.get(S.charAt(right)) > 1) {
                // Remove character from left side of window
                freq.put(S.charAt(left), freq.get(S.charAt(left)) - 1);
                left++;
            }

            //Step 2: Count good windows
            if (right - left + 1 == K) {
                count_of_good_lenK_windows++;
                //Move left window and adjust frequency
                freq.put(S.charAt(left), freq.get(S.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return count_of_good_lenK_windows;
    }
}