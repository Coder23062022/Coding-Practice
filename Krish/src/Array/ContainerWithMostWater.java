package src.Array;

//Problem: https://leetcode.com/problems/container-with-most-water/

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    //Solving by two pointers technique.
    static int maxArea(int[] height) {
        int max_area = 0;
        int low = 0;
        int high = height.length - 1;

        while (low < high) {
            if (height[low] < height[high]) {
                //To calculate the area, you have to consider the difference between the high and low index multiplied by the
                //lowest height. Because, if you will think of a container, you can fill the water till the lowest height only.
                max_area = Math.max(max_area, height[low] * (high - low));
                low++;
            } else {
                max_area = Math.max(max_area, height[high] * (high - low));
                high--;
            }
        }
        return max_area;
    }
}
