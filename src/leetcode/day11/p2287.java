package leetcode.day11;

import org.omg.CORBA.MARSHAL;

public class p2287 {
}

class Solution132123123 {
    public int rearrangeCharacters(String s, String target) {
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < target.length(); i++) {
            arr2[target.charAt(i) - 'a']++;
        }
        int ans = 100000000;
        for (int i = 0; i < 26; i++) {
            if (arr2[i] != 0)
                ans = Math.min(arr1[i] / arr2[i], ans);
        }
        return ans;
    }
}