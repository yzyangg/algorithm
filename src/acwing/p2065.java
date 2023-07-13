package acwing;

import java.io.*;

public class p2065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        while (n > 0) {
            System.out.print(n + " ");
            n /= 2;
        }
    }
}
