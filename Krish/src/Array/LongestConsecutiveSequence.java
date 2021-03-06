package src.Array;

import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//Time complexity: O(n).
//Problem: https://leetcode.com/problems/longest-consecutive-sequence/
//Video source: https://www.youtube.com/watch?v=P6RZZMu_maU&ab_channel=NeetCode

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutiveSequence(nums));
    }

    static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int max = 0;
        for (int i : nums) {
            //If the set doesn't contain the nums[i] element, then it's a starting of a sequence.
            if (!set.contains(i - 1)) {
                int count = 1;
                while (set.contains(i + count)) {
                    count += 1;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
