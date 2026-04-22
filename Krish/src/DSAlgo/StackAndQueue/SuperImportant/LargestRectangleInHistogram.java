package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

//Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
//Video source: https://www.youtube.com/watch?v=Bzat9vgD0fs
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
        for (int i = 0; i < heights.length; i++) { //pse
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
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

    //Time complexity: O(3n)
    //Space complexity: O(3n), two arrays and one stack
    static int largestRectangleAreaMethod2(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        //Find next smaller elements
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        //Clear the stack, if any leftover items are there
        while (!st.isEmpty()) {
            st.pop();
        }

        //Find previous smaller elements
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        //Calculate the area for each height and track maxArea
        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}