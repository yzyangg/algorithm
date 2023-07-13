package acwing;

import java.io.*;

/**
 * @author: yzy
 **/
public class p797 {
    static int N = 100012;
    static int nums[] = new int[N];
    static int sub[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n, m;
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s1[i - 1]);
        }
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int l = Integer.parseInt(s2[0]);
            int r = Integer.parseInt(s2[1]);
            int v = Integer.parseInt(s2[2]);
            sub[l] += v;
            sub[r + 1] -= v;
        }
        for (int i = 1; i <= n; i++) {
            sub[i] += sub[i - 1];
            nums[i] += sub[i];
        }
        for (int i = 1; i <= n; i++) {
            out.print(nums[i] + " ");
        }
        out.flush();


    }
}
