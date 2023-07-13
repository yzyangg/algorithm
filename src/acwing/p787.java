package acwing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p787 {
    static long ans = 0;

    public static void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        if (left >= right) {
            return;
        }
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int i = left, j = mid + 1, k = 0;
        int temp[] = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                ans += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        int idx = 0;
        for (int l = left; l <= right; l++) {
            nums[l] = temp[idx++];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n + 10];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }
        mergeSort(nums, 1, n);

//        for (int i = 1; i <= n; i++) {
//            System.out.print(nums[i] + " ");
//        }
        System.out.println(ans);
    }
}
