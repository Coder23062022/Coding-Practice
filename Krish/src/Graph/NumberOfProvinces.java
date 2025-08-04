package Krish.src.Graph;

//Problem: https://leetcode.com/problems/number-of-provinces/
//Video source: https://www.youtube.com/watch?v=ACzkVtewUYA&ab_channel=takeUforward
//Time complexity: O(n + (v + 2e))
//Space complexity: O(n)

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }

    static int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfsUsingRecursion(i, visited, isConnected);
            }
        }
        return count;
    }

    static void dfsUsingRecursion(int i, boolean[] visited, int[][] isConnected) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfsUsingRecursion(j, visited, isConnected);
            }
        }
    }
}