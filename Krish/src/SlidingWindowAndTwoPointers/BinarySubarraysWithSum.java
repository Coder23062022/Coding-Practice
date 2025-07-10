package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/binary-subarrays-with-sum/
//Video source: https://www.youtube.com/watch?v=XnMdNUkX6VM&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
//        int[] nums = {1, 0, 0, 1, 1, 0};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    static int numSubarraysWithSum(int[] nums, int goal) {
        return countSubArrays(nums, goal) - countSubArrays(nums, goal - 1);
    }

    static int countSubArrays(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }
        return count;
    }
}