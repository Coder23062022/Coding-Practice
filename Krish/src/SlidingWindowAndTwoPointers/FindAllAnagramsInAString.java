package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
//Similar problem: https://leetcode.com/problems/permutation-in-string/
//Video source: https://www.youtube.com/watch?v=XFh_AoEdOTw&ab_channel=TECHDOSE
//Time complexity: O(n). Basically, O(26 * length of s)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        for (int x : findAnagrams(s, p)) {
            System.out.print(x + " ");
        }
    }

    static List<Integer> findAnagrams(String s, String p) {
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