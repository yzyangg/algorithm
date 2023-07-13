package acwing.p200;

import java.io.*;


public class p116 {
    static int n = 4;
    static boolean[][] turned = new boolean[n][n];
    static char[][] graph = new char[n][n];
    static int ans = 0;

    static void turn_all(int u) {
        int x = u / n;
        int y = u % n;
        for (int i = 0; i < n; i++) {
            turn_one(x, i);
            turn_one(i, y);
        }
        turn_one(x, y);
    }

    static void turn_one(int x, int y) {
        graph[x][y] = (graph[x][y] == '+') ? '-' : '+';//翻转+ -
    }

    static boolean check() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (graph[i][j] != '-')
                    return false;
        return true;
    }

    static void dfs(int u) {
        if (u > 15) {//操作完了,一共16个开关，从0号开始到15号遍历完结束。
            if (check()) {//若满足题意打印结果
                System.out.println(ans);
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++) {
                        if (turned[i][j])
                            System.out.println((i + 1) + " " + (j + 1));
                    }
            }
            return;
        }

        turn_all(u);//若翻转这一个开关
        ans++; //则总步数加一
        turned[u / n][u % n] = true; //且这一个开关处于被按了的状况
        dfs(u + 1); //继续遍历下一个开关是否按

        turn_all(u); //这个开关不按
        ans--; // 这个开关不按,ans也要恢复原来的大小
        turned[u / n][u % n] = false; //该开关的状态还原
        dfs(u + 1);//继续遍历下一个开关的情况

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) //初始化
            for (int j = 0; j < n; j++)
                turned[i][j] = false;

        for (int i = 0; i < n; i++) {//读取数据
            String s = br.readLine();
            for (int j = 0; j < n; j++)
                graph[i][j] = s.charAt(j);
        }
        dfs(0);

    }
}
