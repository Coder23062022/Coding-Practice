package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//Video source: https://www.youtube.com/watch?v=vgnhZzw-kfU&ab_channel=codestorywithMIK
//Video source: https://www.youtube.com/watch?v=0snEunUacZY&ab_channel=NeetCode
//Time complexity: O(n * 4^n)
//Space complexity: O(n)

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String temp = "";
        func(0, digits, letters, temp, res);
        return res;
    }

    static void func(int index, String digits, String[] letters, String temp, List<String> res) {
        if (index == digits.length()) {
            res.add(temp);
            return;
        }
        int number = digits.charAt(index) - '0';
        String str = letters[number];
        for (int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);
            func(index + 1, digits, letters, temp, res);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    static List<String> letterCombinationsMethod2(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrack(0, digits, letters, "", result);
        return result;
    }

    static void backtrack(int index, String digits, String[] letters, String currStr, List<String> result) {
        if (currStr.length() == digits.length()) {
            result.add(currStr);
            return;
        }

        int number = digits.charAt(index) - '0';
        String str = letters[number];
        for (char c : str.toCharArray()) {
            backtrack(index + 1, digits, letters, currStr + c, result);
        }
    }
}