package leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p075 {
}

class Solution3223345 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : arr1) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        int ans[] = new int[arr1.length];
        int idx = 0;
        for (int i : arr2) {
            for (Integer integer = 0; integer < count.get(i); integer++) {
                ans[idx++] = i;
            }
            count.remove(i);
        }
        int nowIndex = idx;
        for (Integer integer : count.keySet()) {
            for (Integer i = 0; i < count.get(integer); i++) {
                ans[idx++] = integer;
            }
        }
        Arrays.sort(ans, nowIndex, ans.length);
        return ans;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int biggest = 0;
        for (int i : arr1) {
            biggest = Math.max(biggest, i);
        }
        int temp[] = new int[biggest + 1];
        for (int i : arr1) {
            temp[i]++;
        }
        int idx = 0;
        for (int j : arr2) {
            while (temp[j] > 0) {
                arr1[idx++] = j;
                temp[j]--;
            }
        }
        //已经是有序的了
        for (int i = 0; i <= biggest; i++) {
            while (temp[i] > 0) {
                arr1[idx++] = i;
                temp[i]--;
            }
        }
        return arr1;
    }
}
