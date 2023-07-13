package leetcode.offer;

public class p072 {
}

class Solution231235455 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x / mid == mid) return mid;
            if (x / mid < mid) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid;
            }
        }
        return left;
    }
}