package Strings;

import java.util.Stack;

public class ReverseASentenceWithFirstLetterCapitalOfEachWord {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "This Is An Interview Program";
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        String s = sb.toString();
        int i = 1;
        stack.add(Character.toUpperCase(s.charAt(0)));

        while (i < s.length() - 1) {
            if (s.charAt(i) != ' ') {
                stack.add(s.charAt(i));
            } else {
                char x = Character.toLowerCase(stack.pop());
                stack.add(x);
                stack.add(s.charAt(i));
                i++;
                char y = Character.toUpperCase(s.charAt(i));
                stack.add(y);
            }
            i++;
        }
        stack.add(Character.toLowerCase(s.charAt(s.length() - 1)));
        for (Character ch : stack) {
            System.out.print(ch);
        }
    }
}