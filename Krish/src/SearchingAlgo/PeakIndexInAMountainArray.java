package Krish.src.SearchingAlgo;

//Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/
//Video source: https://www.youtube.com/watch?v=RjxD6UXGlhc&ab_channel=ApnaCollege
//Time Complexity: O(logn)
//Space Complexity: O(1)
//Note: Same as FindPeakElement problem

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}