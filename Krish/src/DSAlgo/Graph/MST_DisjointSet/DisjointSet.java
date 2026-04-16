package Krish.src.DSAlgo.Graph.MST_DisjointSet;

//Problem: https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1
//Video source: https://www.youtube.com/watch?v=aBxjDBC4M1U&ab_channel=takeUforward
//Time complexity: O(4alpha) = O(1), Almost constant time
//Space complexity: O(2n) = O(n), two arrays - rank/size array and parent array

public class DisjointSet {
    public static void main(String[] args) {
        int n = 5;
        DisjointUnionSets dus = new DisjointUnionSets(n);
        dus.unionBySize(0, 2);
        dus.unionBySize(4, 2);
        dus.unionBySize(3, 1);

        if (dus.find(4) == dus.find(0)) System.out.println("Yes");
        else System.out.println("No");

        if (dus.find(1) == dus.find(0)) System.out.println("Yes");
        else System.out.println("No");
    }

    static class DisjointUnionSets {
        int[] rank, size, parent; //You can either use rank or size
        int n;

        //Constructor
        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            size = new int[n];
            this.n = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int node) {
            if (parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }

        void unionByRank(int x, int y) {
            int xRoot = find(x), yRoot = find(y);

            //Elements are in the same set, no need to unite anything.
            if (xRoot == yRoot) return;

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }

        void unionBySize(int x, int y) {
            int xRoot = find(x), yRoot = find(y);

            //Elements are in the same set, no need to unite anything.
            if (xRoot == yRoot) return;

            if (size[xRoot] < size[yRoot]) {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            } else {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            }
        }
    }
}