package src.SlidingWindow;

//Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
//Video source: https://www.youtube.com/watch?v=fvEw13A5O1o&ab_channel=NickWhite
//Time complexity: O(n)
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

    static List<Integer> findAnagramsMethod1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        int[] char_count = new int[26];
        for (char c : p.toCharArray()) {
            char_count[c - 'a']++;
        }

        int left = 0, right = 0;
        int count = p.length();

        while (right < s.length()) {
            //If the character is matched, then decrement the character count in frequency array,
            //increment the right pointer and decrement the count variable.
            if (char_count[s.charAt(right++) - 'a']-- >= 1) count--;

            //At any point, if the count is 0 that means it's an anagram and add the left pointer value in the list as left
            //pointer is pointing to the starting of that anagram in s.
            if (count == 0) result.add(left);

            //Increment the left pointer after every p.length interval (right - left represents the window size here).
            //Also in frequency array, increment the character count of that character which left pointer was pointing to.
            if (right - left == p.length() && char_count[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return result;
    }

    static List<Integer> findAnagramsMethod2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        int[] charCountOfP = new int[26];
        int[] window = new int[26];

        int left = 0, right = 0;
        for (; right < p.length(); right++) {
            charCountOfP[p.charAt(right) - 'a']++;
            window[s.charAt(right) - 'a']++;
        }
        if (Arrays.equals(charCountOfP, window))
            result.add(left);

        while (right < s.length()) {
            window[s.charAt(right) - 'a']++;
            window[s.charAt(left) - 'a']--;
            if (Arrays.equals(charCountOfP, window))
                result.add(left + 1);
            left++;
            right++;
        }
        return result;
    }
}
