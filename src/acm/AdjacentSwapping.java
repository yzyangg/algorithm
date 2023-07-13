package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/5/13 12:51
 */
public class AdjacentSwapping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

    }
}

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            map.put(i, set.size());
        }

        int res[] = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(i) - (map.get(n) - map.get(i));
        }
        return res;
    }
}
