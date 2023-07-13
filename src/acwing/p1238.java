package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: yzy
 **/
public class p1238 {
    static int N = 100000;
    static int nums[][] = new int[N][2];
    static int cnt[] = new int[N];
    static boolean stat[] = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int d = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(s[0]);
            nums[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(nums, 0, n, Comparator.comparingInt(o -> o[0]));
        for (int i = 0, j = 0; i < n; i++) {
            int t = nums[i][1];
            cnt[t]++;
            while (nums[i][0] - nums[j][0] >= d) {
                cnt[nums[j++][1]]--;
            }
            if (cnt[t] >= k) {
                stat[t] = true;
            }
        }
        for (int i = 0; i < 100000; i++) {
            if (stat[i]) {
                System.out.println(i);
            }
        }

    }
}
