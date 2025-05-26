package Krish.src.RecursionAndBackTracking;

//Similar problem: https://leetcode.com/problems/subsets/
//Video source: https://www.youtube.com/watch?v=V0IgCltYgg4&ab_channel=CodeHelp-byBabbar
//Time complexity: O(n * 2^n), where n is the size of the given string
//Space complexity: O(1)

public class PrintAllPossibleSubsequencesOfAString {
    public static void main(String[] args) {
        String input = "abc";
        String output = "";
        System.out.println("All possible subsequences are:");
        printAllSubSequences(0, input, output);
    }

    static void printAllSubSequences(int index, String input, String output) {
        //If index >= input.length(), then we are at the last level of recursion tree.
        if (index == input.length()) {
            //If you want to exclude the space in answer, then add if. Otherwise, 'if' not required.
            if (!output.isEmpty()) System.out.println(output);
            return;
        }

        //include(pick)
        printAllSubSequences(index + 1, input, output + input.charAt(index));
        //exclude(not pick)
        printAllSubSequences(index + 1, input, output);
    }
}