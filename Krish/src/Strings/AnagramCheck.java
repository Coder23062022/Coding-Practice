package Krish.src.Strings;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/valid-anagram
//Video source: https://www.youtube.com/watch?v=IRN1VcA8CGc&ab_channel=NickWhite
//Time complexity: O(n)
//Space complexity: O(26)

public class AnagramCheck {
    //Time Complexity: O(nlogn)
    //Space complexity: O(1)
    static boolean areAnagram(char[] ch1, char[] ch2) {
        //If length of both strings is not same, then they cannot be anagram
        if (ch1.length != ch2.length)
            return false;

        //Sort both the arrays.
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        //Compare sorted arrays.
        for (int i = 0; i < ch1.length; i++)
            if (ch1[i] != ch2[i])
                return false;
        return true;
    }

    static boolean areAnagramWithoutSorting(char[] ch1, char[] ch2) {
        //If length of both strings are not same, then they cannot be anagram
        if (ch1.length != ch2.length)
            return false;

        int[] count = new int[26];

        //Create the frequency array in such a way that for one character array increment each character count and for
        //another character array decrement each character count.
        for (int i = 0; i < ch1.length; i++) {
            count[ch1[i] - 'a']++; //Increment the index of the character
            count[ch2[i] - 'a']--; //Decrement the index of the character
        }

        //At this stage, all elements of count array must be equal to 0 if they are anagram.
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] ch1 = {'t', 'e', 's', 't'};
        char[] ch2 = {'t', 't', 'e', 's'};
        if (areAnagramWithoutSorting(ch1, ch2))
            System.out.println("The two strings are" + " anagram of each other");
        else
            System.out.println("The two strings are not" + " anagram of each other");
    }
}