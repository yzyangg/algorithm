package leetcode.offer;

public class p069 {
}

class Solution0909000 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            else if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else if (arr[mid] > arr[mid + 1]) right = mid - 1;
        }
        return -1;
    }
}