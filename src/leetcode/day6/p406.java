package leetcode.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p406 {
}

class Solution213124 {
    /**
     * 我本来就希望people[][]元素1（h）是身高，元素2（k）是在这位置之前大于于等于当前元素的个数
     * 我应该希望k大的在后面，为了配合k大的在后面，h大的应该在前面
     * 大概按照k升序，h降序排序后我就开始调整位置
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][2]);
    }
}