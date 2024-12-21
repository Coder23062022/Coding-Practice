package Krish.src.Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/3sum/
//Reference video: https://www.youtube.com/watch?v=K-RsltkN63w
//Time complexity: O(nlogn + n^2)
//Space complexity: O(n)

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
            if (i > 0 && nums[i] == nums[i - 1]) continue; //Skip the duplicates

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++; //We need to increase the sum
                } else if (sum > 0) {
                    k--; //We need to decrease the sum
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++; //Skip the duplicates
                }
            }
        }
        return result;
    }
}