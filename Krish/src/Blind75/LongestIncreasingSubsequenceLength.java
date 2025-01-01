package Krish.src.Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/longest-increasing-subsequence/
//Video source: https://www.youtube.com/watch?v=on2hvxBXJH4&ab_channel=takeUforward
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class LongestIncreasingSubsequenceLength {
    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {4, 10, 4, 3, 8, 9};
//        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLISMethod1(nums));
    }

    static int lengthOfLISMethod1(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (result.isEmpty()) {
                result.add(num);
            } else if (num > result.get(result.size() - 1)) {
                result.add(num);
            } else {
                int index = binarySearch(result, num);
                result.set(index, num);
            }
        }
        return result.size();
    }

    static int binarySearch(List<Integer> result, int target) {
        int low = 0, high = result.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (result.get(mid) == target) {
                return mid;
            } else if (result.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    //Video source: https://www.youtube.com/watch?v=CE2b_-XfVDk&t=276s&ab_channel=TusharRoy-CodingMadeSimple
    //Time complexity: O(n^2)
    //Space complexity: O(n)
    static int lengthOfLISMethod2(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        int max = 0;
        for (int re : res) max = Math.max(max, re);
        return max;
    }
}