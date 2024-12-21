package Krish.src.Strings;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Time Complexity: O(n)
//Auxiliary Space: O(256)

public class SecondMostFrequentCharacterInAString {
    static final int ASCII_SIZE = 256;

    // finds the second most frequently occurring char
    static char getSecondMostFreq(String str) {
        // count number of occurrences of every character.
        int[] count = new int[ASCII_SIZE];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        // Traverse through the count[] and find the second highest element.
        int first = 0, second = 0;
        for (int i = 0; i < ASCII_SIZE; i++) {
            // If current element is smaller than first then update both first and second
            if (count[i] > count[first]) {
                second = first;
                first = i;
            }
            // If count[i] is in between first and second then update second
            else if (count[i] > count[second] && count[i] != count[first])
                second = i;
        }
        return (char) second;
    }

    public static void main(String[] args) {
//        String str = "geeksforgeeks";
        String str = "geeksggeeks";
        char res = getSecondMostFreq(str);
        if (res != '\0')
            System.out.println("Second most frequent char" + " is " + res);
        else
            System.out.println("No second most frequent" + "character");
        System.out.println(nthMostFrequentCharacter(str, 2));
    }

    static char nthMostFrequentCharacter(String str, int n) {
        Map<Character, Long> counter = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (counter.size() < n) {
            throw new IllegalArgumentException("Not enough different characters.");
        }
        return counter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toList()).get(n - 1);
    }
}