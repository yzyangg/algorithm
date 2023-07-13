package acwing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1246 {
    static int N = 100010;
    static int nums[] = new int[N];
    static int sub[] = new int[N];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        Arrays.sort(nums, 1, n + 1);
        int arrayGCD = nums[1];
        for (int i = 2; i <= n; i++) {
            arrayGCD = gcd(arrayGCD, nums[i]);
        }
        System.out.println("arrayGCD = " + arrayGCD);
        System.out.println(((nums[n] - nums[1]) / arrayGCD) + 1);

    }




    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
