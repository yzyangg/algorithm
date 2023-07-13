package leetcode.day13;

public class p547 {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            UnionFind uf = new UnionFind(isConnected.length);
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.count;
        }
    }

    class UnionFind {
        int parent[];
        int count;

        public UnionFind(int length) {
            parent = new int[length];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                count++;
            }
        }


        public void union(int i, int j) {
            int A = find(i);
            int B = find(j);
            if (A != B) {
                parent[A] = B;
                count--;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
    }

}
