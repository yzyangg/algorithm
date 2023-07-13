package leetcode.day6;

import java.util.ArrayList;
import java.util.List;

public class p2042 {
    public static void main(String[] args) {

    }
}

class Solution12345 {
    public boolean areNumbersAscending(String s) {
        List<Integer> list = new ArrayList<>();
        String[] strs = s.split(" ");
        int pre = -1;
        for (String str : strs) {
            try {
                int curNumber = Integer.parseInt(str);
                if (curNumber < pre) return false;
                pre = curNumber;
            } catch (NumberFormatException e) {

            }
        }
        return true;
    }

    public boolean areNumbers(String s) {
        int pre = 0, pos = 0;
        while (pos < s.length()) {
            if (Character.isDigit(s.charAt(pos))) {
                int cur = 0;
                while (pos < s.length() && Character.isDigit(s.charAt(pos
                ))) {
                    cur = cur * 10 + s.charAt(pos) - '0';
                    pos++;
                }
                if (cur <= pre) return false;
                pre = cur;
            } else pos++;
        }
        return true;
    }
}