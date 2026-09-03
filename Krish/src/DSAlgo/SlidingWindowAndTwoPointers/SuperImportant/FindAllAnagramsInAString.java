package Krish.src.DSAlgo.SlidingWindowAndTwoPointers.SuperImportant;

//Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
//Video source: https://www.youtube.com/watch?v=egPDpu26q0M
//Time complexity: O(n). Basically, O(26 * length of s)
//Space complexity: O(26) + O(26)

import java.util.*;

public class FindAllAnagramsInAString {
    static void main() {
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

            //Shrink
            if (i >= p.length()) {
                sCount[s.charAt(l) - 'a']--;
                l++;
            }

            if (Arrays.equals(pCount, sCount)) res.add(l);
        }
        return res;
    }

    static List<Integer> findAnagramsMethod2(String s, String p) {
        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int l = 0, r = 0, count = 0;

        while (r < s.length()) {
            if (map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0) count++;

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);

            while (count == p.length()) {
                if (r - l + 1 == p.length()) {
                    res.add(l);
                }
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                if (map.get(s.charAt(l)) > 0) count--;
                l++;
            }

            r++;
        }
        return res;
    }
}