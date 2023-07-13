package leetcode.competition.p343;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yzy
 **/
public class p2 {
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            Map<Integer, Node> map = new HashMap<>();
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    Node node = new Node();
                    node.x = i;
                    node.y = j;
                    node.value = mat[i][j];
                    map.put(mat[i][j], node);
                }
            }
            int l[] = new int[mat.length];
            int r[] = new int[mat[0].length];
            for (int i = 0; i < arr.length; i++) {
                Node node = map.get(arr[i]);
                l[node.y]++;
                r[node.x]++;
                if (l[node.x] == mat[0].length || r[node.y] == mat.length) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Node {
        int x, y;
        int value;

    }
}
