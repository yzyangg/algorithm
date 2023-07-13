package acwing;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class p1562 {
    static int N, L, Q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        List<Integer> lists[] = new List[N + 2];
        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int total = sc.nextInt();
            while (total-- > 0) {
                int follow = sc.nextInt();
                lists[follow].add(i);
            }
        }
        Q = sc.nextInt();
        while (Q-- > 0) {
            int num = sc.nextInt();
            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(num);
            Set<Integer> set = new HashSet<>();
            boolean isNotOverL = true;
            int l = L;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Integer e = queue.pollFirst();
                    for (Integer v : lists[e]) {
                        //转发量 不包括自己
                        if (v != num && !set.contains(v)) {
                            set.add(v);
                            queue.add(v);
                        }
                    }
                }
                l--;
                //本来超过l层 但最多只能l层 退出循环
                if (l == 0) {
                    System.out.println(set.size());
                    isNotOverL = false;
                    break;
                }
            }
            //不超过l层 提前退出循环
            if (isNotOverL) System.out.println(set.size());
        }
    }

}
