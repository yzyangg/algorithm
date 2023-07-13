package leetcode.day7;

import com.sun.org.apache.bcel.internal.Const;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.util.*;

public class p1049 {
    public static void main(String[] args) {
        int arrs[] = {31, 26, 33, 21, 40};
        Solution3435345 solution = new Solution3435345();
        System.out.println(solution.lastStoneWeightII(arrs));

    }
}

class Solution3435345 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int dp[] = new int[15001];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return (sum - dp[target]) - dp[target];
    }

    public int lastStoneWeight(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int length = stones.length;
        int dp[][] = new int[length][target + 1];
        for (int i = stones[0]; i <= target; i++) {
            dp[0][i] = stones[0];
        }
        for (int i = 0; i < length; i++) {
            for (int j = stones[i]; j <= target; j++) {
                //容量超出了
                if (j < stones[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i]] + stones[i]);
            }
        }
        return (sum - dp[length - 1][target]) - dp[length - 1][target];
    }
}
