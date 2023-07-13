package leetcode.offer;

public class p004 {
    public static void main(String[] args) {
        System.out.println(100 ^ 0);
        System.out.println(100 << 1);
        System.out.println(100 >> 1);
    }
}

class Solution53456 {
    /**
     * 其余元素都出现三次，要找到只出现一次的，将所有数字用二进制表示，其余元素的二进制位中的1也会出现三的倍数次
     * 那么对cnt数组每个元素mod3就相当于除去其他元素了，再次遍历cnt还原我们要找的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        //填充二进制数组
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    cnt[i] += 1;
                }
            }
        }
        int ans = 0;
        //还原数字
        for (int i = 0; i < 32; i++) {
            if (((cnt[i] % 3) & 1) == 1) {
                ans += 1 << i;
            }
        }
        return ans;
    }
}
