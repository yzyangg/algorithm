package leetcode.day13;

public class p1905 {
}

class Solution12355 {
    int[][] grid1;
    int[][] grid2;
    boolean isSon;

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        this.grid1 = grid1;
        this.grid2 = grid2;
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //重合并且都等于1

                if (grid2[i][j] == 1) {
                    isSon = true;
                    dfs(i, j);
                    if (isSon) count++;
                }
            }
        }
        return count;

    }

    public void dfs(int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 0;
        if (grid1[i][j] != 1) {
            isSon = false;
        }
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }

}