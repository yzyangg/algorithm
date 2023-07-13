package leetcode.day13;

import java.util.*;

public class p1631 {
}

class Solution3322 {
    public int minimumEffortPath(int[][] heights) {
        int M = heights.length;
        int N = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                //列不越界
                if (j + 1 < N) {
                    edges.add(new int[]{
                            //权值
                            Math.abs(heights[i][j] - heights[i][j + 1]),
                            i * N + j,
                            i * N + j + 1
                    });
                }
                if (i + 1 < M) {
                    edges.add(new int[]{
                            Math.abs(heights[i + 1][j] - heights[i][j]),
                            i * N + j,
                            (i + 1) * N + j
                    });
                }
            }
        }
        edges.sort(Comparator.comparingInt(o -> o[0]));
        UnionFind uf = new UnionFind(N * M);
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.find(0) == uf.find(M * N - 1)) return edge[0];
        }
        return 0;
    }

    class UnionFind {
        int parent[];

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) parent[a] = b;
        }

        public int find(int x) {
            if (x == parent[x]) return x;
            return find(parent[x]);
        }
    }
}