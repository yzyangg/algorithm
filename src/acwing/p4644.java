package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p4644 {
    static int N = 200012;
    static int nums[] = new int[N];
    static int presum[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
            presum[i] = presum[i - 1] + nums[i];
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += (long) nums[i] * (presum[n] - presum[i]);
        }
        System.out.println(res);
    }
}
