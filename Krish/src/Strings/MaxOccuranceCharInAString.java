package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxOccuranceCharInAString {

    public static void main(String[] args) {
//        String str = "sample string";
        String str = "abcd";
        System.out.println("Max occurring character is " + getMaxOccuringCharMeth1(str));
        List<Character> list = getMaxOccuringCharMeth2(str);
        for (Character character : list) {
            System.out.println("Max occurring character is " + character);
        }
    }

    static final int ASCII_SIZE = 256;
    static char getMaxOccuringCharMeth1(String str) {
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
        System.out.println("Count of occurance of the character: " + max);
        return result;
    }

    private static List<Character> getMaxOccuringCharMeth2(String str) {
        Map<Character, Integer> hm = new HashMap<>();
        char[] ch = str.toCharArray();
        int max = 1;
        for (char c : ch) {
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                int oldCount = hm.get(c);
                hm.put(c, oldCount + 1);
                max = Math.max(max, oldCount + 1);
            }
        }
        System.out.println("Count of max occurance:" + max);
        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> m : hm.entrySet()) {
            if (m.getValue() == max) {
                result.add(m.getKey());
            }
        }
        return result;
    }
}