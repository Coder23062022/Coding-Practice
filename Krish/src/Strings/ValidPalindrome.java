package src.Strings;

//Problem: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
//non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
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
}
