package Krish.src.Strings;

//Problem: https://leetcode.com/problems/count-and-say/
//Video source: https://www.youtube.com/watch?v=htSwmFGdFUI&ab_channel=Techdose
//Time complexity: O(2^n)
//Space complexity: O(2^n)

public class CountAndSay {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }

    static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countIdx(s);
        }
        return s;
    }

    static String countIdx(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}