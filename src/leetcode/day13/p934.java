package leetcode.day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class p934 {
}

class Solution0999 {
    int m, n;
    int grid[][];

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int steps[][] = new int[m][n];
        this.grid = grid;
        boolean isBreak = false;
        int minStep = 0;
        for (int i = 0; i < grid.length && !isBreak; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    isBreak = true;
                    break;
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        int newX, newY;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int poll[] = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int[] dir : dirs) {
                    newX = x + dir[0];
                    newY = y + dir[1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 2) continue;
                    if (grid[newX][newY] == 1) return minStep;
                    grid[newX][newY] = 2;
                    queue.offer(new int[]{newX, newY});
                }
            }
            minStep++;
        }
        return -1;
    }

    int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }
        grid[i][j] = 2;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}