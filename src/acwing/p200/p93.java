package acwing.p200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p93 {
    static int nums[] = new int[100];
    static int path[] = new int[100];
    static boolean used[] = new boolean[100];
    static int n;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        if (M==0)return;
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        dfs(1, 1);
    }

    public static void dfs(int u, int idx) {
        if (u > M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = idx; i <= n; i++) {
            path[u] = i;
            dfs(u + 1, i + 1);
        }
    }
}
