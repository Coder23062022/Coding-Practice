package Krish.src.Sorting;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/sort-an-array/?envType=problem-list-v2&envId=merge-sort
//Video source: https://www.youtube.com/watch?v=cQDtOBTy7_Y&ab_channel=ApnaCollege
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    static void merge(int[] nums, int start, int mid, int end) {
        int l = start, r = mid + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;

        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                temp[index++] = nums[l];
                l++;
            } else {
                temp[index++] = nums[r];
                r++;
            }
        }

        while (l <= mid) {
            temp[index++] = nums[l];
            l++;
        }

        while (r <= end) {
            temp[index++] = nums[r];
            r++;
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i + start] = temp[i];
        }
    }
}