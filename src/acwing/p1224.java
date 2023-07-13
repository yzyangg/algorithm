package acwing;

import java.io.*;

/**
 * @author: yzy
 **/
public class p1224 {
    static int N = 10012;
    static int nums[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int pivot = i;
            for (int j = i + 1; j <= n; j++) {
                if (nums[j] < nums[pivot]) {
                    pivot = j;
                }
            }
            if (pivot != i) {
                cnt++;
                int tmp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = tmp;
            }
        }
        out.println(cnt);
        out.flush();
    }
}
