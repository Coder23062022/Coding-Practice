package src.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem: Find the largest number you can form by rearranging the numbers in an integer array.
//Example 1: int[] arr = {3, 30, 34, 5, 9}. Output will be 9543330
//Example 2: int[] arr = {1, 157, 9, 43}. Output will be 9754311
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
//        int[] arr = {1, 157, 9, 43};
        System.out.println(largestNumber(arr));
    }

    static String largestNumber(int[] arr) {
        StringBuilder str = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int j : arr) {
            str.append(j);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i) - '0');
        }
        list.sort(Collections.reverseOrder());

        for (Integer integer : list) {
            result.append(integer);
        }
        return result.toString();
    }
}
