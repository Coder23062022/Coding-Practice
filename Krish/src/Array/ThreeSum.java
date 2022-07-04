package src.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/3sum/
//Reference video: https://www.youtube.com/watch?v=qJSPYnS35SE&t=468s&ab_channel=NickWhite

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //-4, -1, -1, 0, 1, 2

        //Approach: 1. Take the i-th element in each operation and subtract it from 0 and put it into tempSum variable.
        //2. Now find two elements from rest of the array so that their sum is equal to tempSum.
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { //This checks the duplicates, if there are any duplicates, we will skip it.
                int tempSum = 0 - nums[i];

                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == tempSum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high])); //Got a triplet, add it in the list.
                        while (low < high && nums[low] == nums[low + 1]) low++; //To ignore duplicates.
                        while (low < high && nums[high] == nums[high - 1]) high--; //To ignore duplicates.
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > tempSum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
