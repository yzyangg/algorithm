package acwing;


import java.io.IOException;
import java.util.Scanner;

public class p790 {
    static double n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextDouble();
        double left = 0, right = Math.abs(n);

        while (right - left > 1e-8) {
            double mid = (left + right) / 2;
//            if (check(mid) == Math.abs(n)) {
//                System.out.printf("%.6f", mid);
//                return;
//            } else
            if (check(mid) >= n) right = mid;
            else left = mid;
        }
        if (n > 0) {

            System.out.printf("%.6f", left);
        } else {
            left = -left;
            System.out.printf("%.6f", left);
        }
    }

    private static double check(double mid) {
        return (mid * mid * mid);
    }
}
