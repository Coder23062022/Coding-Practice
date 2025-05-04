package Krish.src.Array;

//Problem: https://leetcode.com/problems/trapping-rain-water/
//Video source: https://www.youtube.com/watch?v=UHHp8USwx4M
//Time complexity: O(n)
//Space complexity: O(1)

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    static int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                res += lmax - height[l];
                l++;
            } else {
                res += rmax - height[r];
                r--;
            }
        }
        return res;
    }
}