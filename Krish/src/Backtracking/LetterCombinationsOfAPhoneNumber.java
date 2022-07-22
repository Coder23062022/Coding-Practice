package src.Backtracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//Video source: https://www.youtube.com/watch?v=0snEunUacZY&ab_channel=NeetCode
//Time complexity: O(n * 4^n)
//Space complexity: O(n)

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrack(digits, letters, "", result, 0);
        return result;
    }

    static void backtrack(String digits, String[] letters, String currStr, List<String> result, int index) {
        if (currStr.length() == digits.length()) {
            result.add(currStr);
            return;
        }

        for (char c : letters[digits.charAt(index) - '0'].toCharArray()) {
            backtrack(digits, letters, currStr + c, result, index + 1);
        }
    }
}
