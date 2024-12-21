package Krish.src.LinkedList;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/lru-cache/
//Video source: https://www.youtube.com/watch?v=Xc4sICC8m4M&t=584s&ab_channel=takeUforward
//              https://www.youtube.com/watch?v=NDpwj0VWz1U&ab_channel=NickWhite
//Time complexity: O(1)
//Space complexity: O(n)

public class ImplementLRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int _capacity;

    public ImplementLRUCache(int capacity) {
        _capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == _capacity) {
            remove(tail.prev); //Removing the least recently used node.
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
