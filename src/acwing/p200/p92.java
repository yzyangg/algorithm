package acwing.p200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p92 {
    static int n;
    static boolean visited[] = new boolean[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        dfs(1);
    }

    private static void dfs(int idx) {
        if (idx > n) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            visited[idx] = true;
            dfs(idx + 1);
            visited[idx] = false;
            dfs(idx + 1);
        }
    }
}
