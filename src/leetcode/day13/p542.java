package leetcode.day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class p542 {
}

class Solution12314 {
    int[][] grid;
    int m, n;

    int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        boolean visited[][] = new boolean[m][n];
        int ans[][] = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }

            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] info = queue.pollFirst();
                int x = info[0], y = info[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    //越界或者已经走过了
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) continue;
                    ans[newX][newY] = ans[x][y] + 1;
                    queue.addLast(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return ans;
    }


}