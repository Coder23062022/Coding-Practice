package Krish.src.DSAlgo.Array.SuperImportant;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/subarray-sum-equals-k/
//Video source: https://www.youtube.com/watch?v=xvNwoz-ufXA
//Time complexity: O(n)
//Space complexity: O(n)

public class SubArraySumEqualsK {
    static void main() {
//        int[] nums = {1, 1, 1};
        int[] nums = {3, -3, 1, 1, 1};
        int k = 3;
        System.out.println("Total number of subArrays whose sum equals to k is: " + subArraySum(nums, k));
    }

    static int subArraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (prefix[i] == k) count++;

            if (map.containsKey(prefix[i] - k)) {
                count += map.get(prefix[i] - k);
            }

            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }

    static int subArraySumMethod2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            int prefixSum = sum - k;

            //Uncomment this line if you don't want to put (0, 1) at first in the map.
            //if(sum == k) count++;

            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
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