package Krish.src.Graph.TopoSort;

//Problem: https://www.geeksforgeeks.org/problems/alien-dictionary/1
//Video source: https://www.youtube.com/watch?v=U3N_je7tWAs&t=870s&ab_channel=takeUforward
//Time complexity: O(n * m) , where n is size of array arr[], m is the size of each string arr[i]
//Space complexity: O(26) ≈ O(1)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
//        String[] words = {"cb", "cba", "a", "bc"};
        System.out.println(findOrder(words));
    }

    static String findOrder(String[] words) {
        //Mark characters that exist in the input
        boolean[] exists = new boolean[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        //Build the graph based on adjacent word comparisons
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int j = 0;
            while (j < w1.length() && j < w2.length()) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';
                    adj.get(u).add(v);
                    break;
                }
                j++;
                if (j < w1.length() && j == w2.length()) return "";
            }
        }

        //Topological Sort
        int[] inDegree = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int vertex : adj.get(i)) {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (exists[i] && inDegree[i] == 0) q.offer(i);
        }

        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.append((char) (u + 'a'));

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) q.offer(v);
            }
        }

        //Check for cycle
        for (int i = 0; i < 26; i++) {
            if (exists[i] && inDegree[i] != 0) return "";
        }
        return result.toString();
    }
}