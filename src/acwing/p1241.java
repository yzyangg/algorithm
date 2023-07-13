package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p1241 {
    static int N = 10012;
    static int nums[][] = new int[N][3];
    static int stores[] = new int[N];

    public static void main(String[] args) throws IOException {
        int n, m, t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[0]);
        t = Integer.parseInt(s[0]);
        for (int i = 1; i <= m; i++) {
            String[] s1 = br.readLine().split(" ");
            nums[i] = new int[]{Integer.parseInt(s1[0]), Integer.parseInt(s1[1])};

        }
        Arrays.sort(nums, (o1, o2) -> o1[0] - o2[0]);
        int rank1 = 0, rank2 = 0;
        for (int i = 1; i <= n; i++) {

            if (nums[i][1] != 0) {
                rank1 += 2;
            } else {
                if (rank1 - 1 > 0) rank1 -= 1;
            }
            if (nums[i][2] != 0) {
                rank2 += 2;
            } else {
                if (rank2 - 1 > 0) rank2 -= 1;
            }
            if (i == t) break;
        }

    }
}
