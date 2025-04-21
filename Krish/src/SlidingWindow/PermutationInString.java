package Krish.src.SlidingWindow;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/permutation-in-string/
//Video source: https://www.youtube.com/watch?v=XFh_AoEdOTw&ab_channel=TECHDOSE
//Time complexity: O(n). Basically, O(26 * length of s2)
//Space complexity: O(n).

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        //Initializing two count arrays to hold each character count for both the strings.
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        int left = 0, right = 0;

        while (right < s1.length()) {
            countS1[s1.charAt(right) - 'a']++;
            countS2[s2.charAt(right) - 'a']++;
            right++;
        }
        right--; //To maintain the window.

        while (right < s2.length()) {
            if (Arrays.equals(countS1, countS2)) return true;

            //Discarding the left most character. So decrement its count as we incremented before and increment the left pointer.
            countS2[s2.charAt(left) - 'a']--;
            left++;

            //Increment the right pointer and include the new character present on the right pointer.
            right++;
            if (right != s2.length()) //This check is for the last index when right will become s2.length().
                countS2[s2.charAt(right) - 'a']++;
        }
        return false;
    }
}