package Krish.src.Array;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/majority-element-ii/
//Video source: https://www.youtube.com/watch?v=vwZj1K0e9U8&t=12s&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class MajorityElementII {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 3};
        int[] nums = {2, 2, 3, 1, 3, 2, 1, 1};
        List<Integer> res = majorityElement(nums);
        res.forEach(System.out::println);
    }

    static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != el2) {
                el1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != el1) {
                el2 = num;
                count2 = 1;
            } else if (el1 == num) {
                count1++;
            } else if (el2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (el1 == num) count1++;
            if (el2 == num) count2++;
        }

        if (count1 > nums.length / 3) res.add(el1);
        if (count2 > nums.length / 3) res.add(el2);
        return res;
    }
}