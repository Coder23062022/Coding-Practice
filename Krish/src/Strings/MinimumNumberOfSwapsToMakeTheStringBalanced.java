package Krish.src.Strings;

//Problem: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
//Video source: https://www.youtube.com/watch?v=3YDBT9ZrfaU&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(1)

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwaps(s));
    }

    static int minSwaps(String s) {
        int close = 0, maxClose = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                close -= 1;
            } else {
                close += 1;
            }
            maxClose = Math.max(maxClose, close);
        }
        return (maxClose + 1) / 2;
    }
}