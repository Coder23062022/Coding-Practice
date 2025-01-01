package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/house-robber/description/
//Video Source: https://www.youtube.com/watch?v=UtGtF6nc35g
//Time complexity: O(n)
//Space complexity: O(1)

public class HouseRobber1_MaxSumOfNonAdjacentNumbers {
    public static void main(String[] args) {
        int[] a = {2, 7, 9, 5, 6, 6};
        System.out.println(highestSumOfNonAdjacentNos(a));
    }

    static int highestSumOfNonAdjacentNos(int[] a) {
        int excl = 0, incl = 0;
        for (int x : a) {
            int temp = incl; //Storing the old inclusive to temp.
            incl = Math.max(x + excl, incl); //Formula to calculate the new inclusive.
            excl = temp; //New exclusive will be the old inclusive.
        }
        return incl;
    }
}