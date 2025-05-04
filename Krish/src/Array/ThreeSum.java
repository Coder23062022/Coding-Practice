package Krish.src.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/3sum/
//Similar problem: https://www.geeksforgeeks.org/unique-triplets-sum-given-value/
//Video source: https://www.youtube.com/watch?v=DhFh8Kw7ymk
//Time complexity: O(nlogn) + O(n^2)
//Space complexity: O(k), k is the number of unique triplets

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return result;
    }
}