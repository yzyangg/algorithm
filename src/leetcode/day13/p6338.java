package leetcode.day13;

import java.math.BigInteger;

public class p6338 {
}

class Solutio565n {
    private static final int mod = (int) (1e9 + 7);

    public int monkeyMove(int n) {
        long i = pow(2, n);
        return (int) ((i - 2 + mod) % mod);
    }

    public long pow(long a, int n) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 > 0) {
                ans = a * ans % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return ans;
    }

    public static int quickPow(int a, int n) {
        int temp = a, ans = 1;
        while (n > 0) {
            if (n % 2 == 1) ans *= temp;
            n >>= 1;
            temp *= temp;
        }
        return ans;
    }
}