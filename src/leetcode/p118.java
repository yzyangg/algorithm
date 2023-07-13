package leetcode;

import java.io.*;
import java.util.Arrays;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/5/14 23:19
 */
public class p118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n, k;
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        int[] nums = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(nums, 0, n);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int cnt = 0;
            while (j < n && Math.abs(nums[i] - nums[j]) <= k) {
                j++;
                cnt++;
            }
            res += cnt;
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(res);
        out.flush();

    }
}
