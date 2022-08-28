package src.Array;

//Problem: https://leetcode.com/problems/majority-element/
//Algorithm used: Moore’s Voting Algorithm
//Reference: https://www.geeksforgeeks.org/frequent-element-array/
//Video source: https://www.youtube.com/watch?v=X0G5jEcvroo&ab_channel=AnujBhaiya
//Condition: count(MajorityElement) > arrayLength/2
//Time complexity: O(n)
//Space complexity: O(1)

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int count = 0;
        int mostFreqElement = majorityElement(nums);
        for (int num : nums) {
            if (num == mostFreqElement)
                count++;
        }
        System.out.println("Element " + mostFreqElement + " occurs " + count + " times");
    }

    static int majorityElement(int[] nums) {
        int res = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[res])
                count++;
            else
                count--;

            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        return nums[res];
    }
}
