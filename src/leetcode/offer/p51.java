package leetcode.offer;

public class p51 {
    class Solution {

        int count = 0;

        public int reversePairs(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);
            return count;
        }

        public void mergeSort(int nums[], int left, int right) {
            if (left >= right) return;
            int mid = (left + right) >> 1;
            //左拆分
            mergeSort(nums, left, mid);
            //右拆分
            mergeSort(nums, mid + 1, right);
            //合并
            merge(nums, left, mid, right);
        }

        public void merge(int nums[], int left, int mid, int right) {
            int tempArr[] = new int[right - left + 1];
            int i = left;
            int j = mid + 1;
            int idx = 0;
            while (i <= mid && j <= right) {
                //非逆序对
                if (nums[i] <= nums[j]) {
                    tempArr[idx++] = nums[i++];
                } else {
                    //合并时左边大于右边
                    count += mid - i + 1;
                    tempArr[idx++] = nums[j++];
                }
            }
            while (i <= mid) {
                tempArr[idx++] = nums[i++];
            }
            while (j <= right) {
                tempArr[idx++] = nums[j++];
            }
            //拷贝回原数组
            for (int k = 0; k < tempArr.length; k++) {
                nums[left + k] = tempArr[k];
            }
        }
    }

}

