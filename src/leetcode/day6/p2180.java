package leetcode.day6;

public class p2180 {
    public static void main(String[] args) {
        Solution123545 solution = new Solution123545();
        int a = 233;
        int sum = solution.sum(a);
        System.out.println(sum);
    }
}

class Solution123545 {

    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            if (sum(i) % 2 == 0 && ((sum(i) & 1) == 1)) ans++;
        }
        return ans;
    }

    public int sum(int number) {
        int ans = 0;
        int i = 1;
        while (number > 0) {
            ans += number % 10;
            number /= 10;
        }
        return ans;
    }
}
