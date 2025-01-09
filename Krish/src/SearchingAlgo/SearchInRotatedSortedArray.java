package Krish.src.SearchingAlgo;

//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
//Video reference: https://www.youtube.com/watch?v=5qGrJbHhqFs&ab_channel=takeUforward
//Time complexity: O(logn)
//Space complexity: O(1)

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {1};
        System.out.println(search(nums, 5));
    }

    static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[low]) { //It means left portion is sorted.
                if (target >= nums[low] && target <= nums[mid]) high = mid - 1; //Search in left portion
                else low = mid + 1; //Search in right portion
            } else { //It means right portion is sorted.
                if (target >= nums[mid] && target <= nums[high]) low = mid + 1; //Search in right portion
                else high = mid - 1; //Search in left portion
            }
        }
        return -1;
    }
}