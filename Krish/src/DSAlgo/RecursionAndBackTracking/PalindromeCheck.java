package Krish.src.DSAlgo.RecursionAndBackTracking;

//Video source: https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4
//Time Complexity: O(n)
//Space Complexity: O(n)

public class PalindromeCheck {
    public static void main(String[] args) {
        String s = "MADAM";
        System.out.println(isPalindrome(0, s));
    }

    static boolean isPalindrome(int i, String s) {
        if (i >= s.length() / 2) return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return isPalindrome(i + 1, s);
    }
}