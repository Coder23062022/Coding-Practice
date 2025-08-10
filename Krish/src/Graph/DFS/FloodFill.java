package Krish.src.Graph.DFS;

//Problem: https://leetcode.com/problems/flood-fill/
//Video source: https://www.youtube.com/watch?v=C-2_uSRli8o&ab_channel=takeUforward
//Time complexity: O(n*m), n and m are the number of rows and columns
//Space complexity: O(n*m)

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        for (int[] row : floodFill(image, 1, 1, 2)) System.out.println(Arrays.toString(row));
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] res = image;
        int initColor = image[sr][sc];
        DFSUtil(image, sr, sc, color, initColor, res);
        return res;
    }

    static void DFSUtil(int[][] image, int row, int col, int color, int initColor, int[][] res) {
        if (row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == initColor && res[row][col] != color) {
            res[row][col] = color;
            DFSUtil(image, row + 1, col, color, initColor, res);
            DFSUtil(image, row - 1, col, color, initColor, res);
            DFSUtil(image, row, col + 1, color, initColor, res);
            DFSUtil(image, row, col - 1, color, initColor, res);
        }
    }
}