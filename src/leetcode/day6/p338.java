package leetcode.day6;

public class p338 {
    public static void main(String[] args) {

    }
}

class Solution5462 {
    public int[] countBits(int n) {
        int len = n + 1;
        int ans[] = new int[len];
        for (int i = 0; i <= n; i++) {
            ans[i] = bitCount(i);
        }
        return ans;
    }

    public int bitCount(int number) {
        int ans = 0;
        while (number != 0) {
            number &= (number - 1);
            ans++;
        }
        return ans;
    }

    public int[] countBits2(int n) {
        int bits[] = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                bits[i] = bits[i - 1] + 1;
            } else bits[i] = bits[i / 2];
        }
        return bits;
    }
}