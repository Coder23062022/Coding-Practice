package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/decode-ways/
//Video source: https://www.youtube.com/watch?v=cQX3yHS0cLo&t=19s&ab_channel=KevinNaughtonJr.
//Time complexity: O(n)
//Space complexity: O(n)

public class DecodeWays {
    public static void main(String[] args) {
        String s = "06";
        System.out.println(numDecodings(s));
    }

    static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}