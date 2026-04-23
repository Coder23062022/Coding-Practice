package Krish.src.DSAlgo.SlidingWindowAndTwoPointers;

//Problem: https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
//Video source: https://www.youtube.com/watch?v=cEadsbTeze4
//Time complexity: O(2n)
//Space complexity: O(1)

public class TheCelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},
                {0, 1, 0},
                {0, 1, 1}};
        System.out.println(celebrity(mat));
    }

    static int celebrity(int[][] mat) {
        int n = mat.length;
        int top = 0, down = n - 1;

        while (top < down) {
            if (mat[top][down] == 1) top++;
            else down--;
        }

        for (int i = 0; i < n; i++) {
            if (top != i) {
                if (mat[top][i] != 0 || mat[i][top] != 1) return -1;
            }
        }
        return top;
    }
}