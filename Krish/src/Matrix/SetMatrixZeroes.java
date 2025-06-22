package Krish.src.Matrix;

//Problem: https://leetcode.com/problems/set-matrix-zeroes/
//Video source: https://www.youtube.com/watch?v=N0MgLvceX7M&ab_channel=takeUforward
//Time complexity: O(n*m)
//Space complexity: O(1)

public class SetMatrixZeroes {
    public static void main(String[] args) {
//        int[][] mat = {{1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}};

        int[][] mat = {{0, 1, 2, 0},
                {3, 4, 0, 2},
                {1, 3, 1, 5}};
        setZeroes(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int c0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        c0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (c0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}