package Krish.src.Matrix;

//Problem: https://leetcode.com/problems/search-a-2d-matrix-ii/
//Video source: https://www.youtube.com/watch?v=9ZbB397jU4k&ab_channel=takeUforward
//Time complexity: O(n+m)
//Space complexity: O(1)

public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] mat = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(mat, 5));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}