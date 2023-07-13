package leetcode.day13;

import java.util.Arrays;

public class p6339 {

}

class Solution0999990 {
    //分成k组，每一种分法的得分为每一个组的两端和的和，答案是最大差值
    //选k-1一个分析界限，分数为每个分界线所处于的数，若分界线位于边缘，特殊处理
    public long putMarbles(int[] weights, int k) {
        if (k == 2 && weights.length == 2) return 0;
        int[] doubleScore = new int[weights.length - 1];
        for (int i = 1; i < doubleScore.length; i++) {
            doubleScore[i - 1] = weights[i] + weights[i - 1];
        }
        Arrays.sort(doubleScore);
        long ans = 0;
        int left = 0, right = doubleScore.length - 1;
        while (--k > 0) {
            ans += doubleScore[right--] - doubleScore[left++];
        }
        return ans;
    }
}