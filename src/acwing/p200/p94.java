package acwing.p200;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p94 {
    static int N;
    static int path[] = new int[1000];
    static boolean status[] = new boolean[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(1);
    }


    private static void dfs(int idx) {
        if (idx > N) {
            for (int i = 1; i <= N; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                if (!status[i]) {
                    path[idx] = i;
                    status[i] = true;
                    dfs(idx + 1);
                    status[i] = false;
                }
            }
        }
    }

}
