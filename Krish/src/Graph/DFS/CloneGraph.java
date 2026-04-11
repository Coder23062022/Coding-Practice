package Krish.src.Graph.DFS;

//Problem: https://leetcode.com/problems/clone-graph
//Video source: https://www.youtube.com/watch?v=Nki9V1tD5_I&ab_channel=KeertiPurswani
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {

    }

    static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return cloneUtil(node, map);
    }

    static Node cloneUtil(Node node, Map<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                newNode.neighbors.add(cloneUtil(neighbor, map));
            } else {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}