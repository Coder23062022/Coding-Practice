package Krish.src.Graph;

//Problem: https://leetcode.com/problems/course-schedule/
//Video source: https://www.youtube.com/watch?v=WAOfKpxYHR8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=24
//Time complexity: O(V * E), V and E are the number of vertices and edges
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        //Create the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        //Create the indegree array
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int vertex : adj.get(i)) {
                inDegree[vertex]++;
            }
        }

        //Add all the vertices in the queue which has 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            count++;

            for (int vertex : adj.get(node)) {
                inDegree[vertex]--;
                if (inDegree[vertex] == 0) q.add(vertex);
            }
        }

        //If count == numCourses, that means there is no cycle in the graph (DAG) and all the vertices are covered in topo sort.
        return count == numCourses;
    }
}