package leetcode.Interview_Classic_150_Questions;

/**
 * @author: yzy
 **/
public class l80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int u = 0;
            int k = 2;
            for (int num : nums) {
                if (u < k || nums[u - k] != num) {
                    nums[u++] = num;
                }
            }
            return u;
        }
    }
}
