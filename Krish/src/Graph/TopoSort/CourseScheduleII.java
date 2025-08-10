package Krish.src.Graph.TopoSort;

//Problem: https://leetcode.com/problems/course-schedule-ii/
//Video source: https://www.youtube.com/watch?v=WAOfKpxYHR8&ab_channel=takeUforward
//Time complexity: O(n + m), where n is the number of courses and m is the size of prerequisite array
//Space complexity: O(n + m)

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(Arrays.toString(canFinish(numCourses, prerequisites)));
    }

    static int[] canFinish(int numCourses, int[][] prerequisites) {
        //Create the adjacency list
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
        for (int[] edge : prerequisites) {
            int u = edge[0], v = edge[1];
            adj[v].add(u);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int vertex : adj[i]) {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int neighbor : adj[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return res.size() == numCourses ? res.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}