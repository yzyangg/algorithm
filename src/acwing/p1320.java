package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1320 {
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
            ans += cnt[(int) (preSum[i] % k)];
            cnt[(int) (preSum[i] % k)]++;
        }
        System.out.println(ans);
    }
}
