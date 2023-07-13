package acwing;


import javax.swing.plaf.ProgressBarUI;
import java.io.IOException;
import java.util.Scanner;

public class p789 {
    static int nums[] = new int[100002];
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        while (q-- > 0) {
            int num = sc.nextInt();
            binarySearch(num);
        }
    }

    private static void binarySearch(int num) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != num) {
            System.out.print(-1 + " ");
        } else {
            System.out.print(left - 1 + " ");
        }
        left = 1;
        right = n;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] <= num) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] != num) {
            System.out.print(-1 + " ");
        } else {
            System.out.print(left - 1 + " ");
        }
        System.out.println();
    }

}
