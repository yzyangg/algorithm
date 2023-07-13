package acwing;

import java.io.*;

public class p1227 {
    static int n, k;
    static int N = 100010;
    static int[][] nums = new int[N][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        int idx = 0;
        while (n-- > 0) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            idx++;
            nums[idx][0] = a;
            nums[idx][1] = b;
        }
        int left = 1, right = 100010;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            long cnt = 0;
//            for (int i = 1; i <= n; i++) {
//                cnt += (nums[i][0] / mid) * (nums[i][1] / mid);
//            }
            for (int[] num : nums) {
                cnt += (num[0] / mid) * (num[1] / mid);
            }
            if (cnt >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
