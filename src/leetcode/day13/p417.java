package leetcode.day13;

import java.util.*;

public class p417 {
}

class Solution12345 {
    int n, m;
    int[][] g;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        g = heights;
        m = g.length;
        n = g[0].length;
        Deque<int[]> d1 = new ArrayDeque<>();
        Deque<int[]> d2 = new ArrayDeque<>();
        boolean res1[][] = new boolean[m][n];
        boolean res2[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    res1[i][j] = true;
                    d1.add(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    res2[i][j] = true;
                    d2.add(new int[]{i, j});
                }
            }
        }
        bfs(d1, res1);
        bfs(d2, res2);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(Deque<int[]> d, boolean[][] res) {
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1];
            int val = g[x][y];
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                //不满足非严格递增的条件
                if (res[newX][newY] || g[newX][newY] < val) continue;
                d.addLast(new int[]{newX, newY});
                res[newX][newY] = true;
            }
        }
    }
}