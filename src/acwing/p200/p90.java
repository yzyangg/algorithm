package acwing.p200;

import java.io.*;
import java.util.Scanner;

public class p90 {
    static int n;
    static boolean visited[] = new boolean[n];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        dfs(0);
    }

    private static void dfs(int idx) {
        if (idx > n) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(i + 1 + "");
                }
            }
        } else {
            visited[idx] = true;
            dfs(idx + 1);

            visited[idx] = false;
            dfs(idx + 1);
        }
    }
}
