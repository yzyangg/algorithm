package leetcode.offer;

public class p073 {
}

class Solution334 {
    //找到一个合适的速度e
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = max(piles);
        int ans = 0;
        while (left <= right) {
            int speed = left + (right - left) / 2;
            int time = takesTimes(speed, piles);
            if (time > h) {
                left = speed + 1;
            } else if (time <= h) {
                ans = speed;
                right = speed - 1;
            }
        }
        return ans;
    }

    public int takesTimes(int speed, int piles[]) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time;
    }

    private int max(int[] nums) {
        int ret = Integer.MIN_VALUE;
        for (int i : nums) {
            ret = Math.max(ret, i);
        }
        return ret;
    }
}