package Krish.src.Strings;

//Problem: https://leetcode.com/problems/string-compression/
//Video source: https://www.youtube.com/watch?v=cAB15h6-sWA&ab_channel=ApnaCollege
//Time complexity: O(n)
//Space complexity: O(1)

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(compress(chars));
    }

    static int compress(char[] chars) {
        int n = chars.length, idx = 0;

        for (int i = 0; i < n; i++) {
            char c = chars[i];
            int count = 0;
            while (i < n && chars[i] == c) {
                count++;
                i++;
            }

            if (count == 1) {
                chars[idx++] = c;
            } else {
                chars[idx++] = c;
                String countInString = String.valueOf(count);
                for (int j = 0; j < countInString.length(); j++) {
                    chars[idx++] = countInString.charAt(j);
                }
            }
            i--;
        }
        return idx;
    }
}