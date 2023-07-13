package leetcode.day28;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class p673 {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int length = nums.length;
            int dp[] = new int[length];
            int maxLen = Integer.MIN_VALUE;
            Arrays.fill(dp, 1);
            int val[] = new int[length];
            Arrays.fill(val, 1);
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[i] + 1;
                            val[i] = val[j];
                        } else if (dp[i] == dp[j] + 1) {
                            val[i] += val[j];
                        }
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            for (int i = 0; i < dp.length; i++) {
                System.out.print(dp[i] + " ");
            }
            int ans = 0;
            for (int i = 0; i < val.length; i++) {
                if (dp[i] == maxLen) ans += val[i];
            }
            return ans;
        }
    }
}
