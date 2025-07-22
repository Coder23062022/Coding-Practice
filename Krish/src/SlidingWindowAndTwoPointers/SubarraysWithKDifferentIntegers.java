package Krish.src.SlidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/subarrays-with-k-different-integers/
//Similar problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
//Similar problem: https://leetcode.com/problems/binary-subarrays-with-sum/
//Video source: https://www.youtube.com/watch?v=7wYGbV_LsX4&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    static int helper(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }

            count += (r - l + 1);
            r++;
        }
        return count;
    }
}