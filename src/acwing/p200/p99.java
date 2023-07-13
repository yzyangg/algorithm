package acwing.p200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p99 {
    static int N = 5010;
    static int nums[][] = new int[N][N];
    static int preSum[][] = new int[N][N];
    static int R, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        R = Integer.parseInt(s[1]);
        R = Math.min(R, 5001);
        int x, y, w;
        int Row = R;
        int Col = R;

        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            x = Integer.parseInt(s1[0]) + 1;
            y = Integer.parseInt(s1[1]) + 1;
            w = Integer.parseInt(s1[2]);
            nums[x][y] += w;
            Row = Math.max(Row, x);
            Col = Math.max(Col, y);
        }

        for (int i = 1; i <= Row; i++) {
            for (int j = 1; j <= Col; j++) {
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1] + nums[i][j];
            }
        }
        long maxValue = 0;
        for (int i = 1; i + R <= Row; i++) {
            for (int j = 1; j + R <= Col; j++) {
                maxValue = Math.max(maxValue, preSum[i + R][j + R] - preSum[i + R][j] - preSum[i][j + R] + preSum[i][j]);
            }
        }
        System.out.println(maxValue);
    }
}
