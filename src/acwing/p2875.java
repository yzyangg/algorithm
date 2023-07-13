package acwing;

import java.io.*;
import java.util.PriorityQueue;

public class p2875 {
    static int N = 100001;
    static int nums[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
            queue.add((long) nums[i]);
        }
        long res = 0;
        long a, b;
        while (queue.size() >= 2) {
            a = queue.poll();
            b = queue.poll();
            res += a * b;
            queue.add((a + b));
        }
        out.println(res);
        out.flush();
    }
}
