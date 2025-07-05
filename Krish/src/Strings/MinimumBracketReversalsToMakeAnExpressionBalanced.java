package Krish.src.Strings;

//Problem: https://www.geeksforgeeks.org/problems/count-the-reversals0401/1
//Video source: https://www.youtube.com/watch?v=8q1sma-qMsA&ab_channel=GeeksforGeeks
//Code source: https://www.geeksforgeeks.org/dsa/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
//Time complexity: O(n)
//Space complexity: O(1)

public class MinimumBracketReversalsToMakeAnExpressionBalanced {
    public static void main(String[] args) {
//        String s = "}{{}}{{{";
        String s = "{{}{{}";
        System.out.println(countMinReversals(s));
    }

    static int countMinReversals(String s) {
        if (s.length() % 2 != 0) return -1;

        int open = 0, close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                open++;
            } else {
                if (open == 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        return (int) Math.ceil(open / 2.0) + (int) Math.ceil(close / 2.0);
    }
}