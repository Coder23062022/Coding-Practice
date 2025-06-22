package Krish.src.Matrix;

//Problem: https://leetcode.com/problems/search-a-2d-matrix/
//Video source: https://www.youtube.com/watch?v=JXU4Akft7yk&ab_channel=takeUforward
//Time complexity: O(log(m*n))
//Space complexity: O(1)

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        System.out.println(searchMatrix(mat, 3));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}