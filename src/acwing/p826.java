package acwing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p826 {
    private static int N = 100010;

    private static int head;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int idx;

    private static void init() {
        head = -1;
        idx = 0;
    }

    private static void addToHead(int val) {
        e[idx] = val;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    private static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    private static void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        init();
        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            String act = s[0];
            if (act.equals("H")) {
                int val = Integer.parseInt(s[1]);
                addToHead(val);
            } else if (act.equals("I")) {
                int k = Integer.parseInt(s[1]);
                int val = Integer.parseInt(s[2]);
                add(k - 1, val);
            } else {
                int k = Integer.parseInt(s[1]);

                if (k == 0) {
                    head = ne[head];
                } else {
                    remove(k - 1);
                }
            }

        }
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
