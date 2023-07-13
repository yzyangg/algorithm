package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p1230 {
    static int N = 100002;
    static long preSum[] = new long[N];
    static int cnt[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(br.readLine());
            preSum[i] = preSum[i - 1] + num;
        }
        long ans = 0;
        cnt[0]++;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if ((preSum[j] - preSum[i - 1]) % k == 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }


}
