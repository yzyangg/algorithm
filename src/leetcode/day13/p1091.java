package leetcode.day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class p1091 {
}

class Solution0900 {
    int[][] grid;
    int ans = -1;
    int path = 0;
    int m, n;

    int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1,}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        // 如果起点就阻塞那就玩完啦
        if (grid[0][0] == 1) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] info = queue.pollFirst();
                int x = info[0], y = info[1];
                if (x == m - 1 && y == n - 1) return path;
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 1) continue;
                    queue.addLast(new int[]{newX, newY});
                    grid[newX][newY] = 1;
                }
            }
            path++;
        }

        return path;
    }
}
