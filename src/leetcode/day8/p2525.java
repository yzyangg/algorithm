package leetcode.day8;

public class p2525 {
}

class Solution456456456 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy = false;
        if (mass >= 100) isHeavy = true;
        boolean isBulky = false;
        if (length >= 10000 || width >= 10000 || height >= 10000) isBulky = true;
        double v = length * width * height;
        if (v >= 1000000000) isBulky = true;
        if (isBulky && isHeavy) return "Both";
        else if (isBulky && !isHeavy) return "Bulky";
        else if (!isBulky && isHeavy) return "Heavy";
        else return "Neither";
    }
}