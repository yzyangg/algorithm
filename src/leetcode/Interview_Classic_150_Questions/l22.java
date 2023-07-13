package leetcode.Interview_Classic_150_Questions;

/**
 * @author: yzy
 **/
public class l22 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int j = nums.length - 1;
            for (int i = 0; i <= j; i++) {
                if (nums[i] == val) {
                    swap(nums, i--, j--);
                }
            }
            return j + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
