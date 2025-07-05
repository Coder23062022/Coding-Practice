package Krish.src.Strings;

//Problem: https://leetcode.com/problems/string-to-integer-atoi/
//Solution explain: https://leetcode.com/problems/string-to-integer-atoi/solutions/1402936/java-c-simple-pictorial-explanation-32-bit-int-easy
//Time complexity: O(n)
//Space complexity: O(1)

public class ImplementAtoi {
    public static void main(String[] args) {
        String s = " -042";
        System.out.println(myAtoi(s));
    }

    static int myAtoi(String s) {
        int sign = 1, res = 0, idx = 0;
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            if (s.charAt(idx++) == '-') {
                sign = -1;
            }
        }

        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + (s.charAt(idx++) - '0');
        }
        return res * sign;
    }
}