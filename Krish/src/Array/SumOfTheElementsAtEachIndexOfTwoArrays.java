package Krish.src.Array;

import java.util.ArrayList;
import java.util.List;

//Print the sum of the elements at each index of two arrays such that if the sum is a two digit number, then separate them and print it.
//Time complexity: O(n)
//Space complexity: O(n)

public class SumOfTheElementsAtEachIndexOfTwoArrays {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8};
        int[] brr = {4, 7, 2, 3, 9, 10};

        // Output: 6,1,1,9,1,1,9,10

        // Explanation: 2 + 4 = 6, 4 + 7 = 11 (it's a two digit number, so it will print
        // 1,1) and so on.
        // If there is any extra element present in any of the arrays, then
        // append them at the end of the output. Like 9 and 10 are extra elements here,
        // so appended them at the end.

        meth(arr, brr);
    }

    static void meth(int[] a, int[] b) {
        int sum;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            sum = a[i] + b[i];

            if (sum > 9) {
                int rem;
                while (sum != 0) {
                    rem = sum % 10;
                    sum = sum / 10;
                    list.add(rem);
                }
            } else {
                list.add(sum);
            }
        }
        if (a.length > b.length) {
            int noOfExtraElements = a.length - b.length;
            for (int i = a.length - noOfExtraElements; i < a.length; i++) {
                list.add(a[i]);
            }
        } else {
            int noOfExtraElements = b.length - a.length;
            for (int i = b.length - noOfExtraElements; i < b.length; i++) {
                list.add(b[i]);
            }
        }
        System.out.println(list);
    }
}