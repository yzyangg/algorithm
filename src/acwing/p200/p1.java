package acwing.p200;

import java.io.*;

public class p1 {


    public static void main(String[] args) throws Exception {
        int a, b;
        Read read = new Read();
        a = read.nextInt();
        b = read.nextInt();
        System.out.println(a+b);

    }

    static class Read {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        public int nextInt() throws Exception {
            st.nextToken();
            return (int) st.nval;
        }

        public String readLine() throws Exception {    //	不推荐使用
            st.nextToken();
            return st.sval;
        }
    }
}
