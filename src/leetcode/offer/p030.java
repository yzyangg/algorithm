package leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class p030 {
}

class RandomizedSet {
    private List<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, size++);
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     * 关键在于，删除某个元素后，他相对索引不会改变！！！如何实现？让最后一个元素覆盖要删除的元素，在删除最后一个元素！！
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int OriginIndex = map.get(val);
        int lastEle = list.get(--size);
        list.set(OriginIndex, lastEle);//覆盖
        list.remove(size);
        map.put(lastEle, OriginIndex);//修改
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}
