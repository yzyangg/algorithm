package acwing.p200;

import java.io.*;

/**
 * @author: yzy
 **/
public class p141 {
    static int N = 1000012;
    static int next[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            char[] chars = br.readLine().toCharArray();
            char[] temp = new char[chars.length + 10];
            System.arraycopy(chars, 0, temp, 1, chars.length);
            for (int i = 2, j = 0; i <= n; i++) {
                while (j != 0 && temp[i] != temp[j + 1]) {
                    j = next[j];
                }
                if (temp[i] == temp[j + 1]) {
                    j++;
                }
                next[i] = j;
            }
            out.printf("Test case#%d\n", ++cnt);
            for (int i = 1; i <= n; i++) {
                int t = i - next[i];
                if (i % t == 0 && i / t > 1) {
                    out.printf("%d %d\n", i, i / t);
                }
            }
            out.println();
        }
        out.flush();
    }
}
