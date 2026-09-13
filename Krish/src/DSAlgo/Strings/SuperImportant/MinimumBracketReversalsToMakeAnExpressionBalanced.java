package Krish.src.DSAlgo.Strings.SuperImportant;

//Problem: https://www.geeksforgeeks.org/problems/count-the-reversals0401/1
//Video source: https://www.youtube.com/watch?v=8q1sma-qMsA&ab_channel=GeeksforGeeks
//Code source: https://www.geeksforgeeks.org/dsa/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
//Time complexity: O(n)
//Space complexity: O(1)

public class MinimumBracketReversalsToMakeAnExpressionBalanced {
    static void main() {
//        String s = "}{{}}{{{";
        String s = "{{}{{}";
        System.out.println(countMinReversals(s));
    }

    static int countMinReversals(String s) {
        if (s.length() % 2 != 0) return -1;

        int open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return (int) Math.ceil(open / 2.0) + (int) Math.ceil(close / 2.0);
    }
}