package Krish.src.Blind75;

import java.util.ArrayList;
import java.util.List;

//Problem: https://neetcode.io/problems/string-encode-and-decode
//Video source: https://www.youtube.com/watch?v=B1k_sxOSgv8&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(n)

public class StringEncodeDecode {
    public static void main(String[] args) {
        List<String> strs = List.of("abc", "def", "gh");
        String encodedString = encode(strs);
        System.out.println("Encoded string: " + encodedString);

        List<String> decodedStrings = decode(encodedString);
        System.out.print("Decoded string: ");
        for (String s : decodedStrings) {
            if (s != null)
                System.out.print(s + " ");
        }
    }

    static String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    static List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }
}