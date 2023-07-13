package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p899 {
    static int N = 1012;
    static char[][] strs = new char[N][11];
    static int[][] dp = new int[N][N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            strs[i] = br.readLine().toCharArray();
        }
        while (m-- > 0) {
            int res = 0;
            String[] s1 = br.readLine().split(" ");
            char[] chars = s1[0].toCharArray();
            int limit = Integer.parseInt(s1[1]);
            for (int i = 1; i <= n; i++) {
                if (getMinEdit(strs[i], chars) <= limit) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    //a===>b a编辑成b所需最少编辑字数
    private static int getMinEdit(char[] a, char[] b) {
        int lena = a.length;
        int lenb = b.length;
        for (int i = 1; i <= lena; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= lenb; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                //增删
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                //改 or 不改
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (a[i - 1] == b[j - 1] ? 0 : 1));

            }
        }

        return dp[lena][lenb];
    }
}
