package leetcode.day13;

public class p695 {
}

class Solution123123 {

    int maxCount = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //每块陆地唯一id
                int landIndex = i * n + j;
                //合并
                if (grid[i][j] == 1) {
                    if (i + 1 < m && grid[i + 1][j] == 1) uf.union(landIndex, landIndex + n);
                    if (j + 1 < n && grid[i][j + 1] == 1) uf.union(landIndex, landIndex + 1);
                }
            }
        }
        return maxCount;
    }

    class UnionFind {
        int parent[];
        int size[];

        public UnionFind(int[][] grid) {
            int m = grid.length, n = grid[0].length, landIndex = 0;
            parent = new int[m * n];
            size = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        landIndex = i * n + j;
                        parent[landIndex] = landIndex;
                        size[landIndex] = 1;
                        if (maxCount != 1) maxCount = 1;
                    }
                }
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                if (size[a] > size[b]) {
                    parent[b] = a;
                    size[a] += size[b];
                    maxCount = Math.max(size[a], maxCount);
                } else {
                    parent[b] = a;
                    size[b] += size[a];
                    maxCount = Math.max(size[b], maxCount);
                }
            }
        }
    }

}