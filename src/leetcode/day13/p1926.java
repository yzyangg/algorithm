package leetcode.day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class p1926 {
}

class Solution123545 {
    int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        Deque<int[]> queue = new ArrayDeque<>();
        //行
        int m = maze.length;
        int n = maze[0].length;
        queue.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int minStep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minStep++;
            while (size-- > 0) {
                int[] ints = queue.pollFirst();
                int x = ints[0];
                int y = ints[1];
                if (x == 0 || x == m - 1 || y == 0 || y == n - 1) return minStep;
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || maze[newX][newY] != '.')
                        continue;
                    if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) return minStep;

                    queue.offer(new int[]{newX, newY});
                    maze[newX][newY] = '+';
                }
            }

        }
        return -1;
    }
}