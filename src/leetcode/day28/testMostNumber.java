package leetcode.day28;

public class testMostNumber {
    public static void main(String[] args) {
        int nums[] = {2, 1, 2};
        int number = number(nums);
        System.out.println(number);
    }

    public static int number(int nums[]) {
        int ans = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) k++;
            else if (k == 0) {
                ans = nums[i];
                k = 1;
            } else k--;
        }
        return ans;
    }
}
