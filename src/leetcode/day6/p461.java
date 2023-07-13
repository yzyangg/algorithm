package leetcode.day6;

public class p461 {

}

class Solution56458 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int dif = 0;
        while (z > 0) {
            dif += z & 1;
            z >>= 1;
        }
        return dif;
    }

    public int hammingDistance2(int x, int y) {
        int bigger = Math.max(x, y);
        int smaller = Math.min(x, y);
        int dif = 0;
        while (smaller > 0) {
            if ((smaller & 1) != ((bigger & 1))) {
                dif++;
            }
            smaller >>= 1;
            bigger >>= 1;
        }
        while (bigger > 0) {
            if ((bigger & 1) == 1) {
                dif++;
            }
            bigger >>= 1;
        }
        return dif;
    }
}
