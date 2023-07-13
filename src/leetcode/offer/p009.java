package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class p009 {
    public static void main(String[] args) {
        Solution12312233 solution12312233 = new Solution12312233();
        int[] ints = {10, 5, 2, 6};
        solution12312233.numSubarrayProductLessThanK(ints, 100);
    }
}

class Solution12312233 {
    int k;
    int nums[];
    int count = 0;

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        List<Integer> list = new ArrayList<>();
        dfs(1, 0, list);
        return count;
    }

    public void dfs(int curProduct, int idx, List<Integer> list) {
        if (idx > nums.length || curProduct >= k) return;
        if (curProduct < k && idx != 0) {
            System.out.println(list);
            count++;
        }
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(curProduct * nums[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

class Solution31234 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, right = 0, curProduct = 1;
        int length = nums.length;
        int count = 0;
        while (right < length) {
            curProduct *= nums[right];
            if (curProduct < k) count++;
            while (left < right && curProduct >= k) {
                curProduct /= nums[left];
                left++;
            }
            //固定右边界，有边界左边的所有子数组乘积都满足<k，只需计算个数
            //eg[10,5] k=18
            //ans:10,5,[10,5]
            //0-0+1=1
            //1-0+1=2
            //===>ans =3
            count += right - left + 1;
            right++;
        }
        return count;
    }
}