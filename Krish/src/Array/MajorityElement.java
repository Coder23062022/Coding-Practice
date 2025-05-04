package Krish.src.Array;

//Problem: https://leetcode.com/problems/majority-element/
//Video source: https://www.youtube.com/watch?v=nP_ns3uSh80&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        int[] nums = {2, 3, 7, 3, 4};
        int candidate = majorityElement(nums);
        if (candidate != -1) {
            System.out.println("Majority element is: " + candidate);
        } else {
            System.out.println("No majority element is found");
        }
    }

    static int majorityElement(int[] nums) {
        int count = 0, el = 0;
        for (int j : nums) {
            if (count == 0) {
                el = j;
                count = 1;
            } else if (el == j) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == el) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return el;
        }
        return -1;
    }
}