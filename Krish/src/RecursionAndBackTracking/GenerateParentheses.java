package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Problem: https://leetcode.com/problems/generate-parentheses/
//Video source: https://www.youtube.com/watch?v=s9fokUqJ76A&ab_channel=NeetCode
//Time complexity: O(2^n)
//Space complexity: O(n), recursion stack space

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println("Enter no of parenthesis:");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }

    static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHelper(res, "", 0, 0, n);
        return res;
    }

    static void generateParenthesisHelper(List<String> result, String curr, int open, int close, int n) {
        if (open == n && close == n) { //You can also put this condition here: if (curr.length() == n * 2)
            result.add(curr);
        }

        //Add open parenthesis if open < n.
        if (open < n) {
            generateParenthesisHelper(result, curr + "(", open + 1, close, n);
        }

        //Add close parenthesis only when close < open. Because number of close parenthesis cannot exceed number of open parenthesis.
        //Otherwise, it will not be a valid combination.
        if (close < open) {
            generateParenthesisHelper(result, curr + ")", open, close + 1, n);
        }
    }
}