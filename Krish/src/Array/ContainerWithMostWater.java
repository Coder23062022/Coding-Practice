package Krish.src.Array;

//Problem: https://leetcode.com/problems/container-with-most-water/
//Video reference: https://www.youtube.com/watch?v=UuiTKBwPgAo&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(1)

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    //Solving by two pointers technique.
    static int maxArea(int[] height) {
        int max_area = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            if (height[l] < height[r]) {
                //To calculate the area, you have to consider the difference between the left and right index multiplied by the
                //lowest height. Because, if you will think of a container, you can fill the water till the lowest height only.
                max_area = Math.max(max_area, height[l] * (r - l));
                l++;
            } else {
                max_area = Math.max(max_area, height[r] * (r - l));
                r--;
            }
        }
        return max_area;
    }
}