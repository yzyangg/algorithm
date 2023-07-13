package acwing.p200;

import java.io.*;

/**
 * @author: yzy
 **/
public class p4404 {
    static int N = (int) (1e5 + 12);
    static int[] nums1 = new int[N];
    static int[] nums2 = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int maxN = Integer.parseInt(br.readLine());

        int ma = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= ma; i++) {
            nums1[i] = Integer.parseInt(s1[i - 1]);
        }

        int mb = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        for (int i = 1; i <= mb; i++) {
            nums2[i] = Integer.parseInt(s2[i - 1]);
        }


    }
}
