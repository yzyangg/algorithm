
package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2068 {
    static int N = 1000001;
    static int[] nums = new int[N];
    static int[][] f = new int[11][N];
    static int k = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n;
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        String s1[] = br.readLine().split(" ");
        //初始化+预处理
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s1[i]);
            int t = nums[i] % k;
            for (int j = 0; j < 11; j++) {
                f[j][t]++;
                t = t * 10 % k;
            }
        }
        //计算
        long res = 0L;
        for (int i = 0; i < n; i++) {
            int t = nums[i] % k;
            int len = String.valueOf(nums[i]).length();
            res += f[len][(k - t) % k];
            int r = t;

            //还原
            while (len-- > 0) {
                t = t * 10 % k;
            }
            if (r == (k - t) % k) {
                res--;
            }
        }
        System.out.println(res);
    }

}
