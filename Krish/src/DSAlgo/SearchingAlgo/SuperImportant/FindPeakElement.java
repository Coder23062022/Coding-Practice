package Krish.src.DSAlgo.SearchingAlgo.SuperImportant;

//Problem: https://leetcode.com/problems/find-peak-element/
//Video source: https://www.youtube.com/watch?v=cXxmbemS6XM&t=59s&ab_channel=takeUforward
//Time Complexity: O(logn)
//Space Complexity: O(1)

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Index of the peak element is: " + findPeakElement(nums));
    }

    static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

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