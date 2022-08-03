package src.Strings;

import java.util.*;

public class FirstMaxLengthEvenWord {
    public static void main(String[] args) {
        String str = "geeksforgeeks is a platform for geeks abcdefgh";
        System.out.println(findMaxLenEven(str));
        System.out.println(findMaxLenEvenUsingJava8(str));
    }

    private static String findMaxLenEvenUsingJava8(String str) {
        return Arrays.stream(str.split(" ")).filter(x -> x.length() % 2 == 0).max(Comparator.comparing(String::length))
                .get();
    }

    private static String findMaxLenEven(String str) {
        String[] s = str.split(" ");
        //To maintain the order of insertion, using LinkedHashSet.
        Set<String> setOfEvenLengthWords = new LinkedHashSet<>();
        for (String word : s) {
            if (word.length() % 2 == 0) {
                setOfEvenLengthWords.add(word);
            }
        }

        int maxLength = 0;
        String result = "";
        for (String word : setOfEvenLengthWords) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                result = word;
            }
        }
        return result;
    }
}