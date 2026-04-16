package src.Strings;

import java.util.Arrays;
import java.util.Comparator;

//Problem: https://leetcode.com/problems/largest-number/
//Video source: https://www.youtube.com/watch?v=qEIGhVtZ-sg&ab_channel=TECHDOSE
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumberMethod1(nums));
        System.out.println(largestNumberMethod2(nums));
    }

    static String largestNumberMethod1(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].charAt(0) == '0') return "0"; //Edge-case, all given integers are zeroes.
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }

    static String largestNumberMethod2(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o1o2.compareTo(o2o1) > 0 ? -1 : 1;
            }
        });
        if (arr[0].charAt(0) == '0') return "0"; //Edge-case, all given integers are zeroes.
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
