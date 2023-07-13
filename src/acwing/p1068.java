package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p1068 {
    static int N = 414;
    static int preSum[] = new int[N];
    static int dpMax[][] = new int[N][N];
    static int dpMin[][] = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            preSum[i] = Integer.parseInt(s[i - 1]);
            preSum[n + i] = preSum[i];
        }
        for (int i = 1; i <= 2 * n; i++) {
            preSum[i] += preSum[i - 1];
        }

        //枚举长度
        for (int len = 1; len <= n; len++) {
            //枚举左端点
            for (int l = 1; l + len - 1 <= 2 * n; l++) {
                //计算右端点
                int r = l + len - 1;
                if (len == 1) {
                    dpMax[l][r] = 0;
                    dpMin[l][r] = 0;
                } else {
                    //枚举分割点
                    dpMax[l][r] = Integer.MIN_VALUE;
                    dpMin[l][r] = Integer.MAX_VALUE;
                    for (int k = l; k <= r - 1; k++) {
                        dpMax[l][r] = Math.max(dpMax[l][r], dpMax[l][k] + dpMax[k + 1][r] + preSum[r] - preSum[l - 1]);
                        dpMin[l][r] = Math.min(dpMin[l][r], dpMin[l][k] + dpMin[k + 1][r] + preSum[r] - preSum[l - 1]);
                    }
                }

            }
        }
        int minRes = Integer.MAX_VALUE;
        int maxRes = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            minRes = Math.min(minRes, dpMin[i][n + i]);
            maxRes = Math.max(maxRes, dpMax[i][n + i]);
        }
        System.out.println(minRes);
        System.out.println(maxRes);
    }
}
