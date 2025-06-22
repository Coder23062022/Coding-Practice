package Krish.src.Matrix;

//Problem: https://www.geeksforgeeks.org/problems/c-matrix-rotation-by-180-degree0745/1
//Video source: https://www.youtube.com/watch?v=AHdrAUKB54U&ab_channel=Techdose
//Time complexity: O(n*n)
//Space complexity: O(1)
//Note: If you rotate a matrix 180 degree anticlockwise, then this same solution is applicable as you will get the same result.

public class RotateMatrix180DegreeClockwise {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotate(mat);

        for (int[] m : mat) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(m[j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] matrix) {
        int n = matrix.length;

        //Rotate the matrix 90 degree twice
        int count = 1;
        while (count <= 2) {
            //Transpose
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            //Reverse each row
            for (int[] row : matrix) {
                reverse(row);
            }
            count++;
        }
    }

    static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}