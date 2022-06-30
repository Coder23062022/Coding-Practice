package src.SearchingAlgo;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//Time complexity: O(logn)
//Video reference: https://www.youtube.com/watch?v=bU-q1OJ0KWw&ab_channel=NickWhite

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstIndex(nums, target);
        result[1] = findLastIndex(nums, target);
        return result;
    }

    static int findFirstIndex(int[] a, int target) {
        int l = 0, r = a.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) index = mid;
            if (a[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    static int findLastIndex(int[] a, int target) {
        int l = 0, r = a.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) index = mid;
            if (a[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }
}
