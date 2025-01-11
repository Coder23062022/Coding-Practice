package Krish.src.Strings;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/permutation-in-string/description/
//Video source: https://www.youtube.com/watch?v=XFh_AoEdOTw&ab_channel=Techdose
//Time complexity: O(26 * length of s2) = O(26 * n)
//Space complexity: O(26 + 26) = O(52)

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Hash[s1.charAt(i) - 'a']++;
            s2Hash[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Hash, s2Hash)) return true;

        int l = 0, r = s1.length();
        while (r < s2.length()) {
            s2Hash[s2.charAt(l) - 'a']--;
            s2Hash[s2.charAt(r) - 'a']++;

            if (Arrays.equals(s1Hash, s2Hash)) return true;
            l++;
            r++;
        }
        return false;
    }
}