package leetcode.day13;

public class p2544 {
    public static void main(String[] args) {
        Solution65423 solution65423 = new Solution65423();
        int i = solution65423.alternateDigitSum(886996

        );
        System.out.println(i);
    }
}

class Solution65423 {
    public int alternateDigitSum(int n) {
        int sign = 1;
        int ans = 0;
        while (n != 0) {
            ans += n % 10 * sign;
            n /= 10;
            sign = -sign;
        }
        return ans * -sign;
    }
}