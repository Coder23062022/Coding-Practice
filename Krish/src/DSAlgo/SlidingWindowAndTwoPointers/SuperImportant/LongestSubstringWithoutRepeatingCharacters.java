package Krish.src.DSAlgo.SlidingWindowAndTwoPointers.SuperImportant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Video source: https://www.youtube.com/watch?v=-zSxTJkcdAo&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=4&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class LongestSubstringWithoutRepeatingCharacters {
    static void main() {
        String s = "abcabcbb";
//        String s = "abcbcad";

        int left = 0, right = 0, max = 0;
        HashSet<Character> hashSet = new HashSet<>();

        while (right < s.length()) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right++; // The right pointer is expanding the window here.
                max = Math.max(hashSet.size(), max); // Hashset size is the total number of unique characters in the hashset against the current max.
            } else {
                //Removing characters from left pointer side until the character at right pointer becomes unique in hashset.
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println("Length of the longest substring without repeating characters is: " + max);
        //System.out.println(hashSet);
    }

    static int lengthOfLongestSubstringMethod2(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            while (freq.get(s.charAt(right)) > 1) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                if (freq.get(s.charAt(left)) == 0) freq.remove(s.charAt(left)); //Doesn't matter if you remove this condition also
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}