package leetcode.competition.p114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/5/14 10:06
 */
public class p2 {
    class Solution {
        public int matrixSum(int[][] nums) {
            List<Integer>[] lists = new List[nums.length];
            for (int i = 0; i < nums.length; i++) {
                lists[i] = new ArrayList<>();
                for (int j = 0; j < nums[0].length; j++) {
                    lists[i].add(nums[i][j]);
                }
                Collections.sort(lists[i]);
            }
            int res = 0;
            for (int i = 0; i < nums[0].length; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < nums.length; j++) {
                    max = Math.max(max, lists[j].get(i));
                }
                res += max;
            }
            return res;
        }

    }
}
