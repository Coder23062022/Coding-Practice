package Krish.src.DSAlgo.Strings.SuperImportant;

import java.util.Objects;
import java.util.Stack;

//Problem: https://leetcode.com/problems/decode-string
//Video source: https://www.youtube.com/watch?v=qB0zZpBJlh8
//Time complexity: O(n)
//Space complexity: O(n)

public class DecodeString {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
//        String str = "3[a]2[bc]";
        System.out.println(decodeStringWithSingleStack(str));
    }

    static String decodeStringWithSingleStack(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                st.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder characters = new StringBuilder();
                while (!Objects.equals(st.peek(), "[")) {
                    characters.append(st.pop());
                }
                characters.reverse();
                st.pop(); //Pop the opening bracket

                StringBuilder digits = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    digits.append(st.pop());
                }

                int freq = Integer.parseInt(digits.reverse().toString());

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < freq; j++) {
                    sb.append(characters);
                }
                st.push(sb.reverse().toString());
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }

    static String decodeStringWithTwoStacks(String s) {
        int n = s.length();
        Stack<Integer> countStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        int i = 0;
        String res = "";

        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(charStack.pop());
                int x = countStack.pop();

                for (int j = 0; j < x; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else if (s.charAt(i) == '[') {
                charStack.push(res);
                res = "";
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }
}