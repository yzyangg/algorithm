package leetcode.day13;

public class p733 {

}

class Solution3123455 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        dfs(image, sr, sc, color, oldcolor);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int color, int oldcolor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == color || image[x][y] != oldcolor)
            return;
        image[x][y] = color;
        dfs(image, x + 1, y, color, oldcolor);
        dfs(image, x - 1, y, color, oldcolor);
        dfs(image, x, y + 1, color, oldcolor);
        dfs(image, x, y - 1, color, oldcolor);
    }
}