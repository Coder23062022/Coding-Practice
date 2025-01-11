package Krish.src.Backtracking;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "GOD";
        permutation("", str);
    }

    static void permutation(String result, String word) {
        // If string is empty or contains null or contains space or contains any number,
        // then simply return and print nothing.
        if (word == null || word.length() == 0 || word.contains(" ") || word.matches(".*\\d.*")) {
            System.out.print(result + " ");
            return;
        }

        // Make a boolean array of size '26' which stores false by default and make true
        // at the position which alphabet is being used to make distinct permutation.
        boolean[] visited = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // If the character has not been used then recursive call will take place.
            // Otherwise, there will be no recursive call.
            if (!visited[ch - 'A']) // If the input is in small letters, then here it will be 'a'.
                permutation(result + ch, word.substring(0, i) + word.substring(i + 1));
            visited[ch - 'A'] = true;
        }
    }
}