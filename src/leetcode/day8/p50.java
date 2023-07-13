package leetcode.day8;

public class p50 {
    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));

    }
}

class Solution3242345 {
    public double myPow(double x, int n) {
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        double temp = x, ans = 1;
        while (b > 0) {
            if (b % 2 == 1) ans *= temp;
            b /= 2;
            temp = temp * temp;
        }
        return ans;
    }
}
