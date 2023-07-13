package acwing;

import java.io.*;

public class p1233 {
    static int N = 1012;
    static char[][] map = new char[N][N];
    static boolean[][] vis = new boolean[N][N];
    static boolean flag = false;
    static int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = (s.charAt(j - 1));
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == '#') {
                    vis[i][j] = true;
                    dfs(i, j);
                    //全部淹没
                    if (!flag) {
                        cnt++;
                    }
                    flag = false;
                }
            }
        }
        System.out.println(cnt);


    }

    private static void dfs(int x, int y) {
        if (check(x + 1, y) && check(x - 1, y) && check(x, y + 1) && check(x, y - 1)) {
            flag = true;
        }
        int newX, newY;
        for (int[] dir : dirs) {
            newX = x + dir[0];
            newY = y + dir[1];
            if (!vis[newX][newY] && map[newX][newY] == '#') {
                vis[newX][newY] = true;
                map[newX][newY] = '.';
                dfs(newX, newY);
            }

        }

    }

    static boolean check(int i, int j) {
        return map[i][j] == '#';
    }


}
