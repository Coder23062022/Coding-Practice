package Krish.src.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/longest-increasing-subsequence/
//Video source: https://www.youtube.com/watch?v=on2hvxBXJH4&ab_channel=takeUforward
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class LISWithBinarySearch {
    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {4, 10, 4, 3, 8, 9};
//        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLISMethod1(nums));
    }

    static int lengthOfLISMethod1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            //If it is the first number or the number is greater than the last inserted element in the list, then add it to the result
            if (result.isEmpty() || num > result.get(result.size() - 1)) {
                result.add(num);
            } else {  //If the number is less than the last inserted element, then do a binary search to find out the position where the number can be put and replace the number in that position with the current number
                int index = binarySearch(result, num);
                result.set(index, num);
            }
        }
        return result.size();
    }

    static int binarySearch(List<Integer> result, int target) {
        int low = 0, high = result.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (result.get(mid) == target) {
                return mid;
            } else if (result.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}