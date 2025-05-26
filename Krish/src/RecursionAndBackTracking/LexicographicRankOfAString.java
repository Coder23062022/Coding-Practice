package Krish.src.RecursionAndBackTracking;

//Problem: https://www.geeksforgeeks.org/problems/rank-the-permutations2229/1
//Video source:
//Time complexity: O(n)
//Space complexity: O(1)

public class LexicographicRankOfAString {
    public static void main(String[] args) {
        String str = "acb";
        System.out.println(findRank(str));
    }

    static int findRank(String str) {
        int n = str.length();
        int mul = fact(n);
        int rank = 1;

        // Using a vector of size 26 for lowercase letters
        int[] count = new int[26];

        // Populate the count array for each character in string
        for (int i = 0; i < n; ++i) {
            ++count[str.charAt(i) - 'a'];
        }

        // Convert count to cumulative sum
        for (int i = 1; i < 26; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            mul /= (n - i);

            // Get index of current character in count array
            int charIndex = str.charAt(i) - 'a';

            // Add count of characters smaller than current character
            if (charIndex > 0) {
                rank += count[charIndex - 1] * mul;
            }

            // Update count array
            for (int j = charIndex; j < 26; ++j) {
                --count[j];
            }
        }

        return rank;
    }

    //Factorial
    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}