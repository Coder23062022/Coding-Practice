package Krish.src.Array;

//Problem: https://leetcode.com/problems/find-the-duplicate-number/
//Video source: https://www.youtube.com/watch?v=32Ll35mhWg0&t=328s&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    //Floyd's algorithm
    //Same as linked list cycle detection algorithm
    static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}