package Krish.src.Graph;

//Problem: https://leetcode.com/problems/flood-fill/
//Video source: https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
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
        floodFill(image, 1, 1, 2);
        for (int[] row : image)
            System.out.println(Arrays.toString(row));
    }

    static void floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        int initColor = image[sr][sc];
        DFSUtil(image, sr, sc, color, initColor, visited);
    }

    static void DFSUtil(int[][] image, int sr, int sc, int color, int initColor, int[][] visited) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[sr].length && visited[sr][sc] != 1 && image[sr][sc] == initColor) {
            image[sr][sc] = color;
            visited[sr][sc] = 1;
            DFSUtil(image, sr + 1, sc, color, initColor, visited);
            DFSUtil(image, sr - 1, sc, color, initColor, visited);
            DFSUtil(image, sr, sc + 1, color, initColor, visited);
            DFSUtil(image, sr, sc - 1, color, initColor, visited);
        }
    }
}