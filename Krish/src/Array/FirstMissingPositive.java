package src.Array;

//Problem: https://leetcode.com/problems/first-missing-positive/
//Time complexity: O(n)
//Space complexity: O(1)

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
//        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //First traverse the array and check if there is any number present which is not in the range of 1 to n - 1.
        //If there exist any such number, then replace that number with n + 1 in the array.
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        //Math.abs(nums[i]) <= n : This if check is to ignore the values in the array which are greater than the value of the range of the array.
        //If (nums[j] - 1)th index in the array is a positive number, then make it negative by multiplying with -1.
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) <= n && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        //Now find the first positive number in the new array and return its index + 1.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        //If all the numbers in the new array are negative that means all numbers between 1 to n are present.
        //So return n + 1 in that case.
        return n + 1;
    }
}
