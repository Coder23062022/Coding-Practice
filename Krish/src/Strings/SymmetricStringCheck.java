package src.Strings;

import java.util.HashSet;

public class SymmetricStringCheck {
    // Function to check reflection
    static boolean isReflectionEqual(String s) {
        HashSet<Character> symmetric = new HashSet<>();

        // Symmetric characters
        symmetric.add('A');
        symmetric.add('H');
        symmetric.add('I');
        symmetric.add('M');
        symmetric.add('O');
        symmetric.add('T');
        symmetric.add('U');
        symmetric.add('V');
        symmetric.add('W');
        symmetric.add('X');
        symmetric.add('Y');

        int n = s.length();

        // If any non-symmetric character is present, the answer is NO
        for (int i = 0; i < n; i++) {
            if (!symmetric.contains(s.charAt(i))) {
                return false;
            }
        }

        String rev = s;
        s = Reverse(s);

        // Check if the String is a palindrome
        return rev.equals(s);
    }

    static String Reverse(String s) {
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, charArray.length - 1);
        return new String(charArray);
    }

    // Reverse the letters of the word
    static void reverse(char[] str, int start, int end) {

        // Temporary variable to store character
        char temp;
        while (start <= end) {
            // Swapping the first and last character
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    // Driver code
    public static void main(String[] args) {
        String s = "MYTYM";
        if (isReflectionEqual(s)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}