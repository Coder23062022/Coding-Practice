package Krish.src.Greedy;

//Problem: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
//Video source: https://www.youtube.com/watch?v=UizI7R6ND9Q&ab_channel=NeetCodeIO
//Time complexity: O(n)
//Space complexity: O(1)

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(minAddToMakeValid(s));
    }

    static int minAddToMakeValid(String s) {
        int open = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open != 0) {
                    open--;
                } else {
                    res++;
                }
            }
        }
        return open + res;
    }
}