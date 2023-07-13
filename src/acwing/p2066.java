package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (Character.isLetter(s.charAt(i))) {
                System.out.print(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0' - 1;
                for (int i1 = 0; i1 < num; i1++) {
                    System.out.print(s.charAt(i - 1));
                }
            }
        }

    }
}
