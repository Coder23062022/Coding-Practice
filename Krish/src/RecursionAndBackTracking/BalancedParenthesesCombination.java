package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Problem: https://leetcode.com/problems/generate-parentheses/
//Video source: https://www.youtube.com/watch?v=s9fokUqJ76A&ab_channel=NeetCode
//Time complexity: O(2^n)
//Space complexity: O(n)

public class BalancedParenthesesCombination {
    public static void main(String[] args) {
        List<String> output_list = new ArrayList<>();
        System.out.println("Enter no of parenthesis:");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        backTrack(output_list, "", 0, 0, n);
        System.out.println(output_list);
    }

    static void backTrack(List<String> result, String current_String, int open, int close, int n) {
        // Terminal condition, a well-formed parentheses string length will be the
        // double of the no of parentheses input.
        // This if loop will execute only once at last.
        if (current_String.length() == n * 2) {
            result.add(current_String);
        }

        //Add open parenthesis if open < n.
        if (open < n)
            backTrack(result, current_String + "(", open + 1, close, n);

        //Add close parenthesis only when close < open. Because number of close parenthesis cannot exceed number of open parenthesis.
        //Otherwise, it will not be a valid combination.
        if (close < open)
            backTrack(result, current_String + ")", open, close + 1, n);
    }
}