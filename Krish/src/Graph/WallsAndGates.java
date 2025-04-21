package Krish.src.Graph;

//Problem: https://leetcode.ca/2016-09-11-286-Walls-and-Gates/
//Video source: https://www.youtube.com/watch?v=Pj9378ZsCh4&t=2s&ab_channel=KevinNaughtonJr.

import java.util.Arrays;

public class WallsAndGates {
    static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++)
                if (rooms[i][j] == 0) { //Found a gate.
                    DFSUtil(rooms, i, j, 0);
                }
    }

    static void DFSUtil(int[][] rooms, int row, int col, int count) {
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[row].length || rooms[row][col] < count) {
            return;
        }
        rooms[row][col] = count;
        DFSUtil(rooms, row + 1, col, count + 1);
        DFSUtil(rooms, row - 1, col, count + 1);
        DFSUtil(rooms, row, col + 1, count + 1);
        DFSUtil(rooms, row, col - 1, count + 1);
    }

    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        wallsAndGates(rooms);
        System.out.println("Number of Islands are: " + Arrays.deepToString(rooms));
    }
}