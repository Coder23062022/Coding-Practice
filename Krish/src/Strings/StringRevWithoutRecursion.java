package Strings;

import java.util.Scanner;

public class StringRevWithoutRecursion {
    public static void main(String[] args) {
        System.out.println("Enter string to reverse:");

        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();

        System.out.println("Reversed string is:\n" + method2(str));
    }

    // With StringBuilder
    static String method1(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Without StringBuilder
    static String method2(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}