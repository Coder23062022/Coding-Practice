package Krish.src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/rearrange-array-elements-by-sign/
//Video source: https://www.youtube.com/watch?v=h4aBagy4Uok&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1), not considering the result array space as it's needed to store the answer

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                res[negIndex] = nums[i];
                negIndex += 2;
            } else {
                res[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return res;
    }
}