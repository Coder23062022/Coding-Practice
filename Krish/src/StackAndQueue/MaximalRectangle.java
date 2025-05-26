package Krish.src.StackAndQueue;

//Problem: https://leetcode.com/problems/maximal-rectangle/
//Video source: https://www.youtube.com/watch?v=ttVu6G7Ayik&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=13&ab_channel=takeUforward
//Time complexity: O(m * n) + O(n * 2m)
//Space complexity: O(n * m) + O(n), n*m for prefixSum matrix and O(n) for stack

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    static int maximalRectangle(char[][] matrix) {
        int[][] pSum = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j] - '0';
                if (matrix[i][j] == '0') sum = 0;
                pSum[i][j] = sum;
            }
        }

        int maxArea = 0;
        for (int[] row : pSum) {
            maxArea = Math.max(maxArea, largestRectangleArea(row));
        }
        return maxArea;
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