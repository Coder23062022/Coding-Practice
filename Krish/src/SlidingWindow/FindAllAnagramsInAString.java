package src.SlidingWindow;

//Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
//Similar problem: https://leetcode.com/problems/permutation-in-string/
//Video source: https://www.youtube.com/watch?v=XFh_AoEdOTw&ab_channel=TECHDOSE
//Time complexity: O(n). Basically, O(26 * length of s)
//Time complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        for (int x : findAnagramsMethod2(s, p)) {
            System.out.print(x + " ");
        }
    }

    static List<Integer> findAnagramsMethod2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        int[] charCountOfP = new int[26];
        int[] window = new int[26];

        int left = 0, right = 0;
        while (right < p.length()) {
            charCountOfP[p.charAt(right) - 'a']++;
            window[s.charAt(right) - 'a']++;
            right++;
        }
        right--;

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
