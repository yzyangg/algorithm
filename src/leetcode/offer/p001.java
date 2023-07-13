package leetcode.offer;

public class p001 {
}

class Solution {
    //越界问题
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        //为了防止越界，可以将两个数都转成正数或者负数来计算，此时转换就可能遇到越界问题
        //但是负数不会越界，所以转换成负数处理
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            int value = 0;
            int k = 1;
            while (value >= Integer.MIN_VALUE - value && a <= value + value) {
                value += value;
                k += k;
            }
            a -= value;
            res += k;
        }
        return sign == -1 ? sign : -sign;
    }
}