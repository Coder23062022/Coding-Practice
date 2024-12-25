package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/valid-palindrome/
//Time complexity: O(n)
//Space complexity: O(n)

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("a12a"));
    }

    static boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                result.append(Character.toLowerCase(s.charAt(i)));
            }
            if (Character.isLowerCase(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                result.append(s.charAt(i));
            }
        }
        String s1 = result.toString();
        String s2 = result.reverse().toString();
        return s1.equals(s2);
    }

    //Time complexity: O(nm + n)
    //Space complexity: O(1)
    static boolean isPalindrome1(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}