package leetcode.offer;

public class p006 {

}

class Solution123123 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i, right = numbers.length - 1;
            while (left < right) {
                int mid = (right - left) >> 1 + left;
                if (numbers[mid] + numbers[i] == target) return new int[]{i, mid};
                if (numbers[mid] + numbers[i] > target) {
                    right = mid - 1;
                } else left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}