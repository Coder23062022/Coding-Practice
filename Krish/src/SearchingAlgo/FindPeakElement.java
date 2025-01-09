package Krish.src.SearchingAlgo;

//Problem: https://leetcode.com/problems/find-peak-element/
//Video source: https://www.youtube.com/watch?v=kMzJy9es7Hc&ab_channel=NeetCodeIO
//Time Complexity: O(logn)
//Space Complexity: O(1)

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Index of the peak element is: " + findPeakElement(nums));
    }

    static int findPeakElement(int[] nums) {
        int n = nums.length - 1;
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n] > nums[n - 1]) return n;

        int l = 1, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                r = mid - 1;
            } else if (nums[mid + 1] > nums[mid]) {
                l = mid + 1;
            }
        }
        return -1;
    }
}