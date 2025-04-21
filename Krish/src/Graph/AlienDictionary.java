package Krish.src.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"cb", "cba", "a", "bc"};
        System.out.println(findOrder(words));
    }

    static String findOrder(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(words.length, adj);
        String ans = "";
        for (int i : topo) {
            ans = ans + (char) (i + (int) ('a'));
        }
        return ans;
    }

    static List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int vertex : adj.get(i)) {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            for (int vertex : adj.get(node)) {
                inDegree[vertex]--;
                if (inDegree[vertex] == 0) q.add(vertex);
            }
        }
        return topo;
    }
}