package Krish.src.LinkedList;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/lru-cache/
//Video source: https://www.youtube.com/watch?v=GsY6y0iPaHw&ab_channel=ShradhaKhapra
//Time complexity: O(1)
//Space complexity: O(n)

public class ImplementLRUCache {
    static class Node {
        Node prev, next;
        int key, value;

        Node(int k, int v) {
            key = k;
            value = v;
            prev = next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();
    int limit;

    public ImplementLRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    //Insert a node after head
    private void addNode(Node newNode) {
        Node oldNext = head.next;
        head.next = newNode;
        oldNext.prev = newNode;
        newNode.prev = head;
        newNode.next = oldNext;
    }

    private void deleteNode(Node oldNode) {
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int ans = map.get(key).value;

            //Converting the least recently used node to the most recently used node (Delete and re-insert)
            Node ansNode = map.get(key);
            map.remove(key);
            deleteNode(ansNode);
            addNode(ansNode);
            map.put(key, ansNode);

            return ans;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            deleteNode(oldNode);
            map.remove(key);
        }

        if (map.size() == limit) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}