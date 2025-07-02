package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
//Video source: https://www.youtube.com/watch?v=wuVwUK25Rfc&ab_channel=takeUforward
//Time complexity: O(V * m^V). There is a total of O(m^V) combinations of colors.
//For each attempted coloring of a vertex you call isSafe(), can have up to V–1 neighbors, so isSafe() is O(V)
//Space complexity: O(V + E). The recursive Stack of the graph coloring function will require O(V) space, Adjacency list and color array will required O(V+E).

public class MColoringProblem {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 3}, {2, 3}};
        int m = 3;

        // Check if the graph can be colored with m colors
        // such that no adjacent nodes share the same color
        System.out.println(graphColoring(V, edges, m) ? "true" : "false");
    }

    static boolean graphColoring(int v, int[][] edges, int m) {
        List<Integer>[] adj = new ArrayList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new ArrayList<>();

        //Build adjacency list from edges
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);
        return canColor(0, m, adj, color);
    }

    static boolean canColor(int vertex, int m, List<Integer>[] adj, int[] color) {
        //If all vertices are colored successfully
        if (vertex == color.length) return true;

        //Try all colors from 0 to m-1
        for (int i = 0; i < m; i++) {
            if (isSafe(vertex, i, adj, color)) {
                color[vertex] = i;
                //If the rest can be colored, return true
                if (canColor(vertex + 1, m, adj, color)) return true;
                color[vertex] = -1;
            }
        }
        return false; //No valid coloring found
    }

    static boolean isSafe(int vertex, int currCol, List<Integer>[] adj, int[] color) {
        for (int v : adj[vertex]) {
            //If adjacent vertex has the same color, not safe
            if (currCol == color[v]) return false;
        }
        return true;
    }
}