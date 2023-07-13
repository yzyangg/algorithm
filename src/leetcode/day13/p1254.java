package leetcode.day13;

public class p1254 {
}

class Solution1231234 {
    public int closedIsland(int[][] grid) {
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 0) dfs(grid, i, grid[0].length - 1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0) dfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 0) dfs(grid, grid.length - 1, i);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);

                }
            }
        }
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1 || grid[i][j] == 99) {
            return;
        }
        grid[i][j] = 99;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}