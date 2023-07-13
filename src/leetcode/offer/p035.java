package leetcode.offer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class p035 {
    public static void main(String[] args) {
        String s1 = "01";
        System.out.println(Integer.parseInt(s1));
    }
}

class Solution123123444 {
    /**
     * 一坨屎
     *
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        for (int i = 0; i < timePoints.size(); i++) {
            if (timePoints.get(i).substring(0, 2).equals("00:")) {
                timePoints.set(i, "24" + timePoints.get(i).substring(2));
            } else if (timePoints.get(i).equals("00:00")) {
                timePoints.set(i, "24:00");
            }
        }
        List<String> collect = timePoints.stream().sorted((o1, o2) -> {
            int intPre1 = Integer.parseInt(o1.substring(0, 2));
            int intLast1 = Integer.parseInt(o1.substring(3, 5));
            int intPre2 = Integer.parseInt(o2.substring(0, 2));
            int intLast2 = Integer.parseInt(o2.substring(3, 5));
            if (intPre1 == intPre2) return intLast1 - intLast2;
            return intPre1 - intPre2;
        }).collect(Collectors.toList());
        String o1 = collect.get(collect.size() - 1);
        String o2 = collect.get(collect.size() - 2);
        int intPre1 = Integer.parseInt(o1.substring(0, 2));
        int intLast1 = Integer.parseInt(o1.substring(3, 5));
        int intPre2 = Integer.parseInt(o2.substring(0, 2));
        int intLast2 = Integer.parseInt(o2.substring(3, 5));

        return (intPre1 * 60 + intLast1) - (intPre2 * 60 + intLast2);
    }

    public int findMinDifference2(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int cur = getMinutes(timePoints.get(0));
        int pre = cur;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - pre);
            pre = minutes;
        }
        ans = Math.min(ans, cur + 1440 - pre);
        return ans;
    }

    public int getMinutes(String s1) {
        int pre = Integer.parseInt(s1.substring(0, 2));
        int last = Integer.parseInt(s1.substring(3, 5));
        return pre * 60 + last;
    }
}