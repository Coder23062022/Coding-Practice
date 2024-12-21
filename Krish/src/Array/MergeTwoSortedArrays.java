package Krish.src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/merge-sorted-array/
//Time complexity: O(m + n)
//Space complexity: O(1)

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) return;
        int last = m + n - 1;

        //Merge in reverser order.
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];
                m--;
            } else {
                nums1[last] = nums2[n - 1];
                n--;
            }
            last--;
        }

        //Fill nums1 with leftover nums2 elements.
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
    }
}