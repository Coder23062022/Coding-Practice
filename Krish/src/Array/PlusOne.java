package Krish.src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/plus-one/
//Time complexity: O(n)
//Space complexity: O(n)

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {7, 8, 9, 9};
//        int[] digits = {9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) { //After adding 1 at the last digit, if it's not becoming 10 then that's the answer.
                return digits;
            }
            digits[i] = 0; //If the digit becomes 10 after adding 1, make it 0.
        }

        //If the input is 9 or 99 or 999 or in any 9 series, then in the result array only the first digit we need to make 1 and
        //return it.
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}