package Krish.src.Array;

//Problem: https://www.geeksforgeeks.org/problems/second-largest3735/1
//Video source: https://www.youtube.com/watch?v=37E9ckMDdTk&t=160s
//Time complexity: O(n)
//Space complexity: O(1)

public class SecondLargestAndSmallestInAnArray {
    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 6, 5};
        System.out.println(secondLargestElement(nums));
        System.out.println(secondSmallestElement(nums));
    }

    static int secondLargestElement(int[] nums) {
        int largest = nums[0];
        int secondLargest = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] < largest && nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    static int secondSmallestElement(int[] nums) {
        int smallest = nums[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < smallest) {
                secondSmallest = smallest;
                smallest = nums[i];
            } else if (nums[i] != smallest && nums[i] < secondSmallest) {
                secondSmallest = nums[i];
            }
        }
        return secondSmallest;
    }
}