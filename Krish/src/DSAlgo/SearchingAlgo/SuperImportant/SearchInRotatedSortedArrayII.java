package Krish.src.DSAlgo.SearchingAlgo.SuperImportant;

//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//Video reference: https://www.youtube.com/watch?v=w2G2W8l__pc
//Time complexity: O(logn)
//Space complexity: O(1)

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(nums, 0));
    }

    static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;

            //Duplicates will only cause issue to find the range if nums[low]=nums[mid]=nums[high]
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            if (nums[mid] >= nums[low]) { //It means left portion is sorted.
                if (target >= nums[low] && target <= nums[mid]) high = mid - 1; //Search in left portion
                else low = mid + 1; //Search in right portion
            } else { //It means right portion is sorted.
                if (target >= nums[mid] && target <= nums[high]) low = mid + 1; //Search in right portion
                else high = mid - 1; //Search in left portion
            }
        }
        return false;
    }
}