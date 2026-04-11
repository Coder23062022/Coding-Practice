package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
//Video source: https://www.youtube.com/watch?v=egPDpu26q0M
//Time complexity: O(n). Basically, O(26 * length of s)
//Space complexity: O(26) + O(26)

import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
//        String s = "baa", p = "aa";
        System.out.println(findAnagrams(s, p));
    }

    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                sCount[s.charAt(l) - 'a']--;
                l++;
            }

            if (Arrays.equals(pCount, sCount)) res.add(l);
        }
        return res;
    }
}