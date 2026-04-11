package Krish.src.Blind75;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/subarray-sum-equals-k/
//Video source: https://www.youtube.com/watch?v=KDH4mhFVvHw
//Video source: https://www.youtube.com/watch?v=xvNwoz-ufXA
//Time complexity: O(n)
//Space complexity: O(n)

public class SubArraySumEqualsK {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1}; k =2;
//        int[] nums = {3, -3, 1, 1, 1}; k =3;
        int[] nums = {9, 4, 20, 3, 10, 5};
        int k = 33;
        System.out.println("Total number of subArrays whose sum equals to k is: " + subArraySum(nums, k));
    }

    static int subArraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pS = new int[n];
        pS[0] = nums[0];

        //Calculate prefix sum
        for (int i = 1; i < n; i++) {
            pS[i] = pS[i - 1] + nums[i];
        }

        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (pS[i] == k)
                count++;

            if (hm.containsKey(pS[i] - k)) {
                count += hm.get(pS[i] - k);
            }
            hm.put(pS[i], hm.getOrDefault(pS[i], 0) + 1);
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