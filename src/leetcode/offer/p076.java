package leetcode.offer;

import java.util.PriorityQueue;
import java.util.Random;

public class p076 {
}

class Solution909 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            k--;
            if (k == 0) return nums[i];
        }
        return -1;
    }

    public int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition2(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public int randomPartition(int arr[], int left, int right) {
        Random random = new Random();
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(arr, randomIndex, right);
        return partition(arr, left, right);
    }

    public int partition2(int arr[], int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, left++, i);
            }
        }
        swap(arr, left, right);
        return left;
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Solution9090 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int len = nums.length;
        for (int num : nums) {
            minHeap.offer(num);
        }
        for (int i = k; i < len; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

}