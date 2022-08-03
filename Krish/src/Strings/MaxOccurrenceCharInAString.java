package src.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time complexity: O(n)
//Space complexity: O(n)

public class MaxOccurrenceCharInAString {
    public static void main(String[] args) {
//        String str = "sample string";
        String str = "abcd";
        System.out.println("Max occurring character is " + getMaxOccurringCharMeth1(str));
        List<Character> list = getMaxOccurringCharMeth2(str);
        for (Character character : list) {
            System.out.println("Max occurring character is " + character);
        }
    }

    static final int ASCII_SIZE = 256;

    static char getMaxOccurringCharMeth1(String str) {
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int[] count = new int[ASCII_SIZE];

        // Construct character count array from the input string, count number of
        // occurrences of every character
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        int max = -1; // Initialize max count
        char result = ' '; // Initialize result

        // Traversing through the string and maintaining the count of each character
        for (int i = 0; i < str.length(); i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        System.out.println("Count of occurrence of the character: " + max);
        return result;
    }

    private static List<Character> getMaxOccurringCharMeth2(String str) {
        Map<Character, Integer> hm = new HashMap<>();
        char[] ch = str.toCharArray();
        int max = 1;
        for (char c : ch) {
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                max = Math.max(max, hm.get(c) + 1);
                hm.put(c, hm.get(c) + 1);
            }
        }
        System.out.println("Count of max occurrence:" + max);
        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> m : hm.entrySet()) {
            if (m.getValue() == max) {
                result.add(m.getKey());
            }
        }
        return result;
    }
}