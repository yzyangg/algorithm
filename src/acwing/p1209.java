package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1209 {
    static int N = 10;
    static int nums[] = new int[N];
    static boolean used[] = new boolean[N];
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(1);
        System.out.println(cnt);
    }

    static int sum(int l, int r) {
        int sum = 0;
        while (l <= r) {
            sum = sum * 10 + nums[l];
            l++;
        }
        return sum;
    }


    private static void dfs(int u) {
        if (u >= N) {
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 8; j++) {
                    int left = sum(0, i);
                    int mid = sum(i + 1, j);
                    int right = sum(j + 1, 9);
                    if (n * right == left * right + mid) cnt++;
                }
            }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                nums[u] = i;
                dfs(u + 1);
                used[i] = false;
            }
        }
    }
}
