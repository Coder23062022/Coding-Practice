package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
//Video source: https://www.youtube.com/watch?v=j_QOv9OT9Og&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
//        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
//        int k = 2;
        System.out.println(numSubarraysWithSum(nums, k));
    }

    static int numSubarraysWithSum(int[] nums, int goal) {
        return countSubArrays(nums, goal) - countSubArrays(nums, goal - 1);
    }

    static int countSubArrays(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < nums.length) {
            sum += nums[r] % 2;

            while (sum > goal) {
                sum -= nums[l] % 2;
                l++;
            }

            count += (r - l + 1);
            r++;
        }
        return count;
    }
}