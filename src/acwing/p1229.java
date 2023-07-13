package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class p1229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] all = br.readLine().split("/");
        for (int i = 0; i < 2; i++) {
            checkAndAdd(num[i] + all[0], all[1], all[2]);
            checkAndAdd(num[i] + all[2], all[0], all[1]);
            checkAndAdd(num[i] + all[2], all[1], all[0]);
        }
        for (String i : ans) {
            System.out.println(i);
        }

    }

    static String maxDate = "2059-12-31", minDate = "1960-01-01";
    static String[] num = {"19", "20"};
    static int[] normalMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] leapMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static TreeSet<String> ans = new TreeSet<>();

    public static boolean isLeap(String str) {
        int year = Integer.parseInt(str);
        return (year % 4 == 0 && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static void checkAndAdd(String a, String b, String c) {
        int mon = Integer.parseInt(b);
        int day = Integer.parseInt(c);
        if (mon == 0 || mon > 12) {
            return;
        }
        int maxDay = 0;

        if (isLeap(a)) {
            maxDay = leapMonth[mon];
        } else {
            maxDay = normalMonth[mon];
        }
        if (day > maxDay || day == 0) {
            return;
        }
        String res = a + "-" + b + "-" + c;
        if (res.compareTo(maxDate) <= 0 && res.compareTo(minDate) >= 0) {
            ans.add(res);
        }
    }
}
