package leetcode.offer;

public class p041 {
}

class MovingAverage {

    /**
     * Initialize your data structure here.
     */
    private int[] temp;
    private int size;
    private double curSum;

    public MovingAverage(int size) {
        this.size = size;
        this.temp = new int[size];
        this.curSum = 0;
    }

    public double next(int val) {
        size++;
        curSum += val;
        int leavePos = (size - 1) % temp.length;
        if (size > temp.length) {
            curSum -= temp[leavePos];
        }
        return curSum / (size > temp.length ? temp.length : size);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */