package Krish.src.Matrix;

//Problem: https://leetcode.com/problems/spiral-matrix/
//Video source: https://www.youtube.com/watch?v=XMpdvwUObho&ab_channel=ApnaCollege
//Video source: https://www.youtube.com/watch?v=3Zv-s9UUrFM&ab_channel=takeUforward
//Time complexity: O(n*m)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        List<Integer> res = spiralOrder(mat);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int srow = 0, erow = matrix.length - 1;
        int scol = 0, ecol = matrix[0].length - 1;

        while (srow <= erow && scol <= ecol) {
            //top
            for (int i = scol; i <= ecol; i++) {
                res.add(matrix[srow][i]);
            }

            //right
            for (int i = srow + 1; i <= erow; i++) {
                res.add(matrix[i][ecol]);
            }

            //bottom
            for (int i = ecol - 1; i >= scol; i--) {
                if (srow == erow) break;
                res.add(matrix[erow][i]);
            }

            //left
            for (int i = erow - 1; i >= srow + 1; i--) {
                if (scol == ecol) break;
                res.add(matrix[i][scol]);
            }

            srow++;
            erow--;
            scol++;
            ecol--;
        }
        return res;
    }
}