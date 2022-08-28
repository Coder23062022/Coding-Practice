package src.Strings;

//Encora interview question: Given a string consists of numbers and alphabets comma separated. Find out the largest number present in the string.
//Time complexity: O(n)
//Space complexity: O(1)

public class FindLargestNumber {
    public static void main(String[] args) {
        String input = "12,33,abc,xyz,4a5";
        System.out.println(getLargestNumber(input));
    }

    static int getLargestNumber(String input) {
        int hand = 0, max = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ',') {
                max = Math.max(max, hand);
                hand = 0;
            } else if (ch >= '0' && ch <= '9') {
                hand = hand * 10 + (ch - '0');
            } else {
                hand = 0;
            }
        }
        max = Math.max(max, hand);
        return max;
    }
}
