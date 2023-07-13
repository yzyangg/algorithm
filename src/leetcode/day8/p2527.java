package leetcode.day8;

public class p2527 {
}

class Solution45436 {
    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    ans ^= (calcu(nums[i], nums[j], nums[k]));
                }
            }
        }
        return ans;
    }

    public int calcu(int i, int j, int k) {
        return (i | j) & k;
    }

    public int xorBeauty2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}