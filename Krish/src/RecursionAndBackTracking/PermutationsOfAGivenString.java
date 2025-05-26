package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem: https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
//Video source: https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=15&ab_channel=takeUforward
//Time Complexity: O(n! * n)
//Space Complexity: O(n!)

public class PermutationsOfAGivenString {
    public static void main(String[] args) {
        String s = "ABC";
        List<String> res = findPermutation(s);
        for (String x : res) {
            System.out.print(x + " ");
        }
    }

    static List<String> findPermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);
        recurPermute(0, str, ans);
        return ans;
    }

    static void recurPermute(int index, StringBuilder s, List<String> ans) {
        if (index == s.length()) {
            ans.add(s.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            swap(s, index, i);
            recurPermute(index + 1, s, ans);
            swap(s, index, i);
        }
    }

    static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    static void permutationMethod2(String result, String word) {
        // If string is empty or contains null or contains space or contains any number,
        // then simply return and print nothing.
        if (word == null || word.length() == 0 || word.contains(" ") || word.matches(".*\\d.*")) {
            System.out.print(result + " ");
            return;
        }

        // Make a boolean array of size '26' which stores false by default and make true
        // at the position which alphabet is being used to make distinct permutation.
        boolean[] visited = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // If the character has not been used then recursive call will take place.
            // Otherwise, there will be no recursive call.
            if (!visited[ch - 'A']) // If the input is in small letters, then here it will be 'a'.
                permutationMethod2(result + ch, word.substring(0, i) + word.substring(i + 1));
            visited[ch - 'A'] = true;
        }
    }
}