package Krish.src.SlidingWindow;

//Problem: https://leetcode.com/problems/minimum-window-substring/
//Video source: https://www.youtube.com/watch?v=WJaij9ffOIY&ab_channel=takeUforward
//Time complexity: O(2n) + O(m), where n and m are the length of string s and t respectively
//Space complexity: O(256)

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    static String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n) {
            return "";
        }

        int l = 0, r = 0;
        int minLength = Integer.MAX_VALUE, startIdx = -1;
        int count = 0;

        int[] chars = new int[256];
        for (int i = 0; i < m; i++) {
            chars[t.charAt(i)]++;
        }

        while (r < n) {
            char c = s.charAt(r);
            if (chars[c] > 0) {
                count++;
            }
            chars[c]--;

            while (count == m) {
                int currentLength = r - l + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    startIdx = l;
                }
                chars[s.charAt(l)]++;
                if (chars[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }
}