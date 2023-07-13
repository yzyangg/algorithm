package leetcode.competition.p340;

/**
 * @author: yzy
 **/
public class p1 {
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (check(nums[i][i])) {
                res = Math.max(nums[i][i], res);
            }
            if (check(nums[i][nums.length - 1 - i])) {
                res = Math.max(nums[i][nums.length - 1 - i], res);
            }
        }
        System.out.println(check(1));
        return res;
    }

    private boolean check(int i) {
        for (int j = 2; j < i / j; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
