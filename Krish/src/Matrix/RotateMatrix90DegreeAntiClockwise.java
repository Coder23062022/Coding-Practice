package Krish.src.Matrix;

//Problem: https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
//Time complexity: O(n*n)
//Space complexity: O(1)

public class RotateMatrix90DegreeAntiClockwise {
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

        //Reverse each row
        for (int[] row : matrix) {
            reverse(row);
        }

        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
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
