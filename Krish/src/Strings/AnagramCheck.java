package Strings;

import java.util.Arrays;

//Time Complexity: O(nLogn)

public class AnagramCheck {
    static boolean areAnagram(char[] ch1, char[] ch2) {
        // If length of both strings is not same, then they cannot be anagram
        if (ch1.length != ch2.length)
            return false;

        // Sort both the arrays.
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        // Compare sorted arrays.
        for (int i = 0; i < ch1.length; i++)
            if (ch1[i] != ch2[i])
                return false;
        return true;
    }

    /* Driver program */
    public static void main(String[] args) {
        char[] ch1 = {'t', 'e', 's', 't'};
        char[] ch2 = {'t', 't', 'e', 'w'};
        if (areAnagram(ch1, ch2))
            System.out.println("The two strings are" + " anagram of each other");
        else
            System.out.println("The two strings are not" + " anagram of each other");
    }
}