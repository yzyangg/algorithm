package leetcode.day8;

import java.util.ArrayList;
import java.util.List;

public class p2526 {
}

class DataStream {
    int value;
    int k;
    int count = 0;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if (num == value) count++;
        else count = 0;
        return count >= k;
    }
}
