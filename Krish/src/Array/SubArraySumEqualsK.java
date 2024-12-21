package Krish.src.Array;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/subarray-sum-equals-k/
//Video source: https://www.youtube.com/watch?v=xvNwoz-ufXA
//Time complexity: O(n)
//Space complexity: O(n)

public class SubArraySumEqualsK {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1};
        int[] nums = {3, -3, 1, 1, 1};
        int k = 3;
        System.out.println("Total number of subArrays whose sum equals to k is: " + subArraySum(nums, k));
    }

    static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;

            //Uncomment this line if you don't want to put (0, 1) at first in the map.
            //if(sum == k) count++;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}