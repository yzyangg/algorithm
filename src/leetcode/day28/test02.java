package leetcode.day28;

import java.util.Arrays;

public class test02 {
    public static void main(String[] args) {

    }

    public void Discretization() {
        int nums[] = {199, 23, 899, 1000, 323};
        int length = nums.length;
        int temp[] = new int[length];
        System.arraycopy(nums, 0, temp, 0, length);
        Arrays.sort(temp);
        int arrs[] = new int[length];
        for (int i = 0; i < length; i++) {
            arrs[i] = Arrays.binarySearch(temp, nums[i]) + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + "映射后" + arrs[i]);
        }
    }
}
