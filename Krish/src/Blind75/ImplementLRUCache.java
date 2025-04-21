package Krish.src.Blind75;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/lru-cache/
//Video source: https://www.youtube.com/watch?v=GsY6y0iPaHw&ab_channel=ShradhaKhapra
// https://www.youtube.com/watch?v=Xc4sICC8m4M&t=584s&ab_channel=takeUforward
//Time complexity: O(1)
//Space complexity: O(n)

public class ImplementLRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }

    static class LRUCache {
        Node head = new Node(0, 0), tail = new Node(0, 0);
        Map<Integer, Node> map = new HashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        static class Node {
            Node prev, next;
            int key, value;

            Node(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private void addNode(Node newNode) {
            Node oldNext = head.next;
            head.next = newNode;
            newNode.next = oldNext;
            newNode.prev = head;
            oldNext.prev = newNode;
            map.put(newNode.key, newNode);
        }

        private void delNode(Node oldNode) {
            Node oldNext = oldNode.next;
            Node oldPrev = oldNode.prev;
            oldPrev.next = oldNext;
            oldNext.prev = oldPrev;
            map.remove(oldNode.key);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node ansNode = map.get(key);
            int ans = ansNode.value;
            delNode(ansNode);
            addNode(ansNode);
            return ans;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node oldNode = map.get(key);
                delNode(oldNode);
            }

            if (map.size() == capacity) {
                delNode(tail.prev);
            }

            Node newNode = new Node(key, value);
            addNode(newNode);
        }
    }
}