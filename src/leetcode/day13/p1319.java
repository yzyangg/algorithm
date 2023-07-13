package leetcode.day13;

public class p1319 {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) return -1;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < connections.length; i++) {
                unionFind.union(connections[i][0], connections[i][1]);
            }
            return unionFind.count - 1;
        }
    }

    class UnionFind {
        int parent[];
        int rank[];
        int count;

        public UnionFind(int n) {

            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < parent.length; i++) {
                rank[i] = 1;
                parent[i] = i;
            }

        }

        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                if (rank[a] > rank[b]) {
                    parent[b] = a;
                } else {
                    parent[a] = b;
                }
                if (rank[a] == rank[b]) rank[a]++;
                count--;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
    }
}
