package Krish.src.Backtracking;

//Similar problem: https://leetcode.com/problems/subsets/
//Video source: https://www.youtube.com/watch?v=V0IgCltYgg4&ab_channel=CodeHelp-byBabbar
//Time complexity: O(n * 2^n), where n is the size of the given string
//Space complexity: O(1)

public class PrintAllPossibleSubsequencesOfAString {
    public static void main(String[] args) {
        String input = "abc";
        String output = "";
        System.out.println("All possible subsequences are:");
        printAllSubSequences(input, output, 0);
    }

    static void printAllSubSequences(String input, String output, int index) {
        //If index >= input.length(), then we are at the last level of recursion tree.
        if (index >= input.length()) {
            //If you want to exclude the space in answer, then add if. Otherwise, 'if' not required.
            if (!output.isEmpty()) System.out.println(output);
            return;
        }

        //exclude
        printAllSubSequences(input, output, index + 1);

        //include
        printAllSubSequences(input, output + input.charAt(index), index + 1);
    }
}