package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p1024 {
    static int N = 100002;
    static int nums[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(nums, Integer.MAX_VALUE);
        int a = 0, b = 0, begin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                int idx = Integer.parseInt(s[j]);
                begin = Math.min(begin,idx);
                //违背使用
                if (nums[idx] == Integer.MAX_VALUE) {
                    nums[idx] = idx;
                } else {
                    //重了
                    b = idx;
                }
            }
        }
//        System.out.println("begin==>"+begin);
        for (int i = begin; i <= 100002; i++) {

            if (nums[i] == Integer.MAX_VALUE) {
                a = i;
                break;
            }
        }
        System.out.println(a + " " + b);
    }
}
