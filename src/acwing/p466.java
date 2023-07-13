package acwing;


import java.util.Scanner;

public class p466 {
    private static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean check_valid(int date) {
        int year = date / 10000;//舍弃掉后面4位
        int month = date / 100 % 100;//先舍弃掉后面2位，然后得到6位中的最后两位
        int day = date % 100;//得到8位中的最后两位
        if (month < 1 || month > 12) return false;//判断月份是否合法
        if (day < 1 || month != 2 && day > days[month]) return false;//判断不是2月份的天数是否合法
        if (month == 2) {
            int leap = 0;
            if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0) {
                leap = 1;//若闰年则有29天
            }
            if (day > 28 + leap) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int date1 = scanner.nextInt();
        int date2 = scanner.nextInt();
        int res = 0;
        for (int i = 1000; i < 10000; i++) {
            int date = i;
            int x = i;
            for (int j = 0; j < 4; j++) {
                date = date * 10 + x % 10;
                x /= 10;
            }
            if (date1 <= date && date <= date2 && check_valid(date)) res++;
        }
        System.out.println(res);
    }
}