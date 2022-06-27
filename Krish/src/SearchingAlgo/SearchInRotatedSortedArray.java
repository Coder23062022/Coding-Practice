package src.SearchingAlgo;

//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums, 6));
    }

    static int findMin(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target <= nums[m]) r = m;
                else l = m + 1;
            } else {
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m;
            }
        }
        return target == nums[l] ? l : -1;
    }
}
