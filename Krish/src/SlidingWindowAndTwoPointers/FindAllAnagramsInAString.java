package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
//Video source: https://www.youtube.com/watch?v=WJaij9ffOIY&ab_channel=takeUforward
//Video source: https://www.youtube.com/watch?v=XFh_AoEdOTw&ab_channel=TECHDOSE
//Similar problem: https://leetcode.com/problems/minimum-window-substring/
//Similar problem: https://leetcode.com/problems/permutation-in-string/
//Time complexity: O(n). Basically, O(26 * length of s)
//Space complexity: O(256)

import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
//        String s = "baa", p = "aa";
        System.out.println(findAnagrams(s, p));
    }

    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;

        //Fill the map with the character frequencies of p string
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        //Run the sliding window for s string
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

    static List<Integer> findAnagramsMethod2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        int[] charCountOfP = new int[26];
        int[] window = new int[26];
        int left = 0, right = 0;

        //Fill both the array's indexes upto the length of smaller string size.
        while (right < p.length()) {
            charCountOfP[p.charAt(right) - 'a']++;
            window[s.charAt(right) - 'a']++;
            right++;
        }
        right--; //Because right was unnecessarily increased by 1 in the last while loop.

        //At this point, charCountOfP is ready and this won't be changed anymore.
        //Now, we can traverse till the end of the main array.
        //While traversing, remove one letter from left and add one letter from right and increase both the pointers.

        while (right < s.length()) {
            if (Arrays.equals(charCountOfP, window))
                result.add(left);

            window[s.charAt(left) - 'a']--;
            left++;
            right++;
            if (right != s.length())
                window[s.charAt(right) - 'a']++;
        }
        return result;
    }
}