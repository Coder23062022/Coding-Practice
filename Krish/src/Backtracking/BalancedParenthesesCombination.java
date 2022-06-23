package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if (open < n)
            backTrack(result, current_String + "(", open + 1, close, n);
        if (close < open)
            backTrack(result, current_String + ")", open, close + 1, n);
    }
}