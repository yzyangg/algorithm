package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class test01 {
    static int N = 1012;
    static int[] primes = new int[N];
    static boolean st[] = new boolean[N];
    static int cnt = 1;

    public static void main(String[] args) {
        getPrimes(100);
        for (int i = 1; i <= cnt; i++) {
            System.out.print(primes[i] + " ");

        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = i * i; j <= n; j += i) {
                st[j] = true;
            }
        }
    }
}
