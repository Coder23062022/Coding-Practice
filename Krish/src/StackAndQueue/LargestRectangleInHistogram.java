package Krish.src.StackAndQueue;

//Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
//Video source: https://www.youtube.com/watch?v=Bzat9vgD0fs&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=12&ab_channel=takeUforward
//Time complexity: O(2n)
//Space complexity: O(n)

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int nse = i; //next smaller element
                int pse = stack.isEmpty() ? -1 : stack.peek(); //previous smaller element
                int width = nse - pse - 1;
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        //Leftover elements in the stack has no next smaller element. So, we assign length of the height array in nse.
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int nse = heights.length;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int width = nse - pse - 1;
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}