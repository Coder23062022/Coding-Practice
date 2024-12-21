package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {2, 1};
        System.out.println(findMin(nums));
    }

    static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            if (nums[low] < nums[high]) return nums[low];
            int mid = (low + high) / 2;
            if (nums[mid] >= nums[low]) //That means left portion is sorted. Need to search in the right portion.
                low = mid + 1;
            else
                high = mid; //That means right portion is sorted. Need to search in the left portion.
        }
        return nums[low];
    }
}