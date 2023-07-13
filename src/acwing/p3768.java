package acwing;

import java.io.*;

/**
 * @author: yzy
 **/
public class p3768 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] chars = s.toCharArray();
        int res = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'x') {
                int j = i;
                int cnt = 0;
                while (j < chars.length && chars[j] == 'x') {
                    cnt++;
                    j++;
                }
                if (cnt >= 3) {
                    res += cnt - 2;
                }
                i = j;
            }
            i++;
        }
        out.println(res);
        out.flush();
    }
}
