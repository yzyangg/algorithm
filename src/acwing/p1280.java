package acwing;


import java.io.*;
import java.nio.channels.SelectionKey;

public class p1280 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int cnt = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                cnt++;
                c1[i] = c2[i] == '*' ? 'o' : '*';
                c1[i + 1] = c2[i + 1] == '*' ? 'o' : '*';
            }
        }
        System.out.println(cnt);
    }
}
