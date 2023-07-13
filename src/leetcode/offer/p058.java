package leetcode.offer;

import java.util.*;

public class p058 {
}

class MyCalendar {
    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (list.size() == 0) {
            list.add(new int[]{start, end});
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            if (ints[0] < end && start < ints[1]) return false;
        }
        list.add(new int[]{start, end});
        return true;
    }
}

class MyCalendar2 {
    private TreeMap<Integer, Integer> map;

    public MyCalendar2() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(start);

        if (floor != null && floor.getValue() > start) {
            return false;
        }
        if (ceiling != null && ceiling.getKey() < end) return false;
        map.put(start, end);
        return true;
    }
}