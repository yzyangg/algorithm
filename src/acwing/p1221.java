package acwing;

import java.io.*;

public class p1221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int a = 0; a * a * 4 <= n; a++) {
            for (int b = a ; a * b + 3 * b * b <= n; b++) {
                for (int c = b ; a * a + b * b + 2 * c * c <= n; c++) {
                    int d = (int) Math.sqrt(n - a * a - b * b - c * c);
                    if (a * a + b * b + c * c + d * d == n) {
                        out.println(a + " " + b + " " + c + " " + d);
                        out.flush();
                        out.close();
                        return;
                    }
                }
            }
        }
    }
}
