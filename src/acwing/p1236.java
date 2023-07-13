package acwing;


import com.sun.media.sound.RIFFInvalidDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1236 {
    static int N = 100012;
    static int nums[][] = new int[3][N];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 3; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                nums[i][j] = Integer.parseInt(s[j - 1]);
            }
            Arrays.sort(nums[i], 0, n + 1);
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int key = nums[1][i];
            int idx1 = findSmlBig(key, nums[0]);
            int idx2 = findBigSmall(key, nums[2]);
            if (idx1 == 0 || idx2 == n + 1) {
                continue;
            }
            ans += (long) (idx1 - 1) * (n - idx2);
        }
        System.out.println(ans);
    }

    private static int findSmlBig(int key, int[] num) {
        int left = 0, right = n + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int findBigSmall(int key, int[] num) {
        int left = 0, right = n + 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (num[mid] <= key) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
