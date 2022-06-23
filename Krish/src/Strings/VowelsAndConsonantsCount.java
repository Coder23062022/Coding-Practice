package Strings;

public class VowelsAndConsonantsCount {
    public static void main(String... args) {
        //String s = "I am a good boy";
        String s = "yellow is yellow";
        findNumberOfVowelsAndConsonant(s);
    }

    private static void findNumberOfVowelsAndConsonant(String input) {
        int vowelsCount = 0;
        int consonantCount = 0;
        String vowels = "aeiouy";

        char[] inputCharArray = input.toCharArray();

        for (char c : inputCharArray) {
            if (vowels.indexOf(c) != -1) {
                vowelsCount++;
            } else if (c != ' ') {
                consonantCount++;
            }
        }

        System.out.println("Vowels count: " + vowelsCount);
        System.out.println("Consonants count: " + consonantCount);
    }
}