package acwing;

import java.io.*;

public class p902 {
    static int N = 1012;
    static int dp[][] = new int[N][N];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());
        char[] c1 = br.readLine().toCharArray();
        int m = Integer.parseInt(br.readLine().trim());
        char[] c2 = br.readLine().toCharArray();
        int la = c1.length;
        int lb = c2.length;
        for (int i = 1; i <= la; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= lb; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (c1[i - 1] == c2[j - 1] ? 0 : 1));
            }
        }

        System.out.println(dp[la][lb]);
    }
}
