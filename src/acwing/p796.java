package acwing;

import java.util.Scanner;

public class p796 {
    static int N = 1012;
    static int preSum[][] = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, q;
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        int num;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                num = sc.nextInt();
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + num;
            }
        }
        while (q-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int value = preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1];
            System.out.println(value);
        }
    }
}
