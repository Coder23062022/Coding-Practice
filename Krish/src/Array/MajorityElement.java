package Krish.src.Array;

//Problem: https://leetcode.com/problems/majority-element/
//Algorithm used: Moore’s Voting Algorithm
//Condition: count(MajorityElement) > arrayLength/2

//Reference: https://www.geeksforgeeks.org/frequent-element-array/
//Video source: https://www.youtube.com/watch?v=n5QY3x_GNDg
//Video source: https://www.youtube.com/watch?v=X0G5jEcvroo&ab_channel=AnujBhaiya
//Time complexity: O(n)
//Space complexity: O(1)

public class MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {2, 3, 7, 3, 4};
        int count = 0;
        int candidate = findCandidate(nums);
        for (int num : nums) {
            if (num == candidate)
                count++;
        }
        if (count > nums.length / 2) {
            System.out.println("Element " + candidate + " occurs " + count + " times");
        } else {
            System.out.println("No majority element is found as condition of count(MajorityElement) > arrayLength/2 is not met.");
        }
    }

    static int findCandidate(int[] nums) {
        int majorityIndex = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[majorityIndex] == nums[i])
                count++;
            else
                count--;

            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        return nums[majorityIndex];
    }
}