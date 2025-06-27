package Krish.src.SearchingAlgo;

//Problem: https://leetcode.com/problems/split-array-largest-sum/
//Video source: https://www.youtube.com/watch?v=thUd_WJn6wk&ab_channel=takeUforward
//Time complexity: O(n) + O(n * log(Range)), Range = Sum(arr) - MAX(arr)
//Space complexity: O(1)
//Note: Same solution as AllocateMinimumPages

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    static int splitArray(int[] nums, int k) {
        if (k > nums.length) return -1;
        int sum = 0;
        for (int j : nums) {
            sum += j;
        }

        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }

        int low = maxVal, high = sum, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int k, int maxSum) {
        int countOfSubArrays = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= maxSum) {
                sum += arr[i];
            } else {
                countOfSubArrays++;
                sum = arr[i];
            }
            if (countOfSubArrays > k) return false;
        }
        return true;
    }
}
