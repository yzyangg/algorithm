package leetcode.day13;

public class p1020 {
}

class Solution123455 {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) dfs(grid, i, grid[0].length - 1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) dfs(grid, grid.length - 1, i);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += grid[i][j];
            }
        }
        return count;
    }

    public void dfs(int grid[][], int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {

            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int dfsCount(int grid[][], int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {

            return 0;
        }
        grid[i][j] = 0;
        int cur = 1;
        cur += dfsCount(grid, i + 1, j);
        cur += dfsCount(grid, i - 1, j);
        cur += dfsCount(grid, i, j + 1);
        cur += dfsCount(grid, i, j - 1);
        return cur;
    }
}
