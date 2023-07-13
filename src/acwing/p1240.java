package acwing;

import java.io.*;

/**
 * @author: yzy
 **/
public class p1240 {
    static int N = 100012;
    static int nums[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        int ans = 0;
        long max = -Long.MAX_VALUE;
        for (int d = 1, i = 1; i <= n; i *= 2, d++) {
            long curSum = 0;
            for (int j = i; j <= (1 << d - 1) + i && j <= n; j++) {
                curSum += nums[j];
            }
            if (curSum > max) {
                ans = d;
                max = curSum;
            }
        }
        out.println(ans);
        out.flush();

    }
}
