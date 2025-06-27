package Krish.src.SearchingAlgo;

//Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//Video reference: https://www.youtube.com/watch?v=nhEMDKMB44g&ab_channel=takeUforward
//Time complexity: O(logn)
//Space complexity: O(1)

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
        int low = 0, high = nums.length - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            //That means left portion is sorted. Take the minimum (which is nums[low]) and search in the right portion.
            if (nums[mid] >= nums[low]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                //That means right portion is sorted. Take the minimum (which is nums[mid]) and search in the left portion.
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}