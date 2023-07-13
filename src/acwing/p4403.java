package acwing;

import java.io.*;

/**
 * @author: yzy
 **/
public class p4403 {
    static int N = 10012;
    static int nums[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            out.println(Math.max((n - i) * 2, (i - 1) * 2));
        }
        out.flush();
    }
}
