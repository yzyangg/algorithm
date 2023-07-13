package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1210 {
    static int N = 10012;
    static int nums[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MIN_VALUE;
            for (int j = i; j <= n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.max(min, nums[j]);
                if (max - min == j - i) cnt++;
            }
        }
        System.out.println(cnt);
    }

}
