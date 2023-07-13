package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p730 {
    static int N = 100009;
    static int nums[] = new int[N];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        int max = N;
        int min = 0;
        while (min < max) {
            int mid = (min + max) >> 1;
            if (check(mid)) max = mid;
            else min = mid + 1;
        }
        System.out.println(min);
    }

    private static boolean check(int mid) {
        for (int i = 1; i <= n; i++) {
            mid = 2 * mid - nums[i];
            if (mid >= 1e5) return true;
            if (mid < 0) return false;
        }
        return true;
    }
}
