package leetcode.day6;

import java.util.HashMap;
import java.util.Map;

public class p76 {
    public static void main(String[] args) {
        Solution321 solution321 = new Solution321();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        solution321.minWindow(s, t);
    }
}

class Solution12 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        int cnt = 0;
        int len = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt++;
            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }

            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }

        }
        return ans;
    }
}

class Solution321 {
    public String minWindow(String s, String t) {
        //维护s串中滑动窗口中各个字符出现次数
        Map<Character, Integer> hs = new HashMap<>();
        //维护t串中各个字符出现次数
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        //cnt维护s串[left,right]中满足t串的元素的个数，记录相对应字符的总数
        int len = Integer.MAX_VALUE, cnt = 0;
        //区间[left,right]表示当前滑动窗口
        for (int left = 0, right = 0; right < s.length(); right++) {
            hs.put(s.charAt(right), hs.getOrDefault(s.charAt(right), 0) + 1);
            //如果ht表中也包含当前字符
            if (ht.containsKey(s.charAt(right))) {
                //并且hs表中的字符个数<=ht表中的字符个数,说明该字符是必须的，并且还未到达字符串t所要求的数量
                if (hs.get(s.charAt(right)) <= ht.get(s.charAt(right))) {
                    cnt++;
                }
            }
            //收缩滑动窗口
            //如果左边界的值不在ht表中 或者 它在hs表中的出现次数多于ht表中的出现次数
            while (left < right && (!ht.containsKey(s.charAt(left)) || hs.get(s.charAt(left)) > ht.get(s.charAt(left)))) {
                hs.put(s.charAt(left), hs.get(s.charAt(left)) - 1);
                left++;
            }
            //此时滑动窗口包含符串 t 的全部字符
            if (cnt == t.length() && right - left + 1 < len) {
                len = right - left + 1;
                ans = s.substring(left, right + 1);
            }
        }
        return ans;
    }

    public String minWinodw2(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        //window中合法的局部结果
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //窗口中的某一词的词频与目标词频相同
                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (valid == need.size()) {
                //更新最小值
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //删除窗口左端值
                char leave = s.charAt(left);
                left++;
                if (need.containsKey(leave)) {
                    if (window.get(leave).equals(need.get(leave))) valid--;
                    window.put(leave, window.get(leave) - 1);
                }
            }
        }
        //更新窗口
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
